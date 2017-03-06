package tv.lycam.services;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import lycamPlusSdk.lycam.internal.LycamplusOperation;
import lycamPlusSdk.lycam.model.LycamplusUser;
import lycamPlusSdk.lycam.model.ObjectListing;
import lycamPlusSdk.lycam.utils.JsonUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tv.lycam.domain.*;


@Service
public class MessageServiceImpl extends LycamplusOperation implements MessageService{

	private static Logger logger= Logger.getLogger(MessageServiceImpl.class);

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private GiftServiceImpl giftService;

	@Transactional
	@Override
	public MessageResponse sendMessage(Message message) {
		// TODO Auto-generated method stub
		String receiverId=message.getReceiver();
		String topic=message.getTopic();
		int type=message.getType();
		String body=message.getContent();
		String userName=message.getUsername();
		String senderId=message.getClient();
		String avatarUrl=message.getAvatarUrl();
		int showType=message.getShowType();//消息展现
		try {
			if(body!=null) {
				body = URLEncoder.encode(body, "UTF-8");//获取消息内容
			}

			if(receiverId!=null) {
				receiverId = URLEncoder.encode(receiverId, "UTF-8");// 可以为个人或群体
			}
			if(topic!=null) {
				topic = URLEncoder.encode(topic, "UTF-8");// Topic
			}
			if(senderId!=null) {
				senderId = URLEncoder.encode(senderId, "UTF-8");//用户id
			}
			if(userName!=null) {
				userName = URLEncoder.encode(userName, "UTF-8");//用户名
			}
			if(avatarUrl!=null) {
				avatarUrl = URLEncoder.encode(avatarUrl, "UTF-8");//头像
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		MessageBody messageBody=new MessageBody(body, userName,receiverId,avatarUrl, type, showType);
		messageBody.setOnlineCount(getUsersByTopic(topic).size());//获取房间人数

		//如果消息是送礼物类型则，需要处理消费逻辑
		if(type==1){
			String giftId=body;
			messageBody=giftService.sendGift(senderId, receiverId, giftId,messageBody);

		}
		//如果消息展示类型是弹幕类型，则需要扣费
		if(showType==1){
			dealFloatMessage(senderId);
		}

		String jsonMessageBody= JsonUtils.getInstance().obj2json(messageBody);

		return sendMqttMessageRequest(senderId,jsonMessageBody,topic,message.getQos(),message.getRetain());
	}

	@Transactional
	@Override
	public List<User> getUsersByTopic(String topic) {
		List<LycamplusUser> lycamplusUsers;
		//发送http请求并获得用户ID的json数据
		HttpGet httpGet=new HttpGet("http://api.mqtt.lycam.tv:3000/mqtt/subscribers?topic="+topic);
//		CloseableHttpClient httpClient= HttpClients.createDefault();
//		CloseableHttpResponse response=null;
//		String res="";
//		try {
//			response = httpClient.execute(httpGet);
//			HttpEntity responseEntity=response.getEntity();
//			if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
//				res=responseEntity!=null? EntityUtils.toString(responseEntity,"utf-8") : "";
//			}else{
//				throw new HttpOperationException(EntityUtils.toString(responseEntity,"utf-8"));
//			}
//
//		}  catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		lycamplusUsers=doOperation(httpGet,false,new TypeReference<ObjectListing<LycamplusUser>>(){});

		List<User> userList=new ArrayList<User>();

		for(LycamplusUser lycamplusUser:lycamplusUsers){
			String userId = lycamplusUser.getUuid();
			User user = userService.getUserById(userId);
			if(user != null){
				userList.add(user);
			}
		}

		return userList;
	}


	//private static String token="dXNlcjpwYXNzd2Q=";
	public MessageResponse sendMqttMessageRequest(String client, String message, String topic, int qos, int retain){
		HttpPost httpPost=new HttpPost("http://api.mqtt.lycam.tv:3000/mqtt/publish");
		httpPost.addHeader("content-type", "application/x-www-form-urlencoded");
		String strBody="client="+client+"&message="+message+"&topic="+topic
						+"&qos="+qos+"&retain="+retain;
		StringEntity entity=new StringEntity(strBody,"utf-8");
		httpPost.setEntity(entity);

		return doOperation(httpPost,false,MessageResponse.class);

	}

	
	public void dealFloatMessage(String senderId){
		User sender=userService.getUserById(senderId);
		if(sender!=null) {
			int balance = sender.getBalance();
			if (balance >= 1) {
				sender.setBalance(balance - 1);
				sender.setExperience(balance * 10);
				sender.setContribution(balance + 1);
			}
		}
	}




 }
