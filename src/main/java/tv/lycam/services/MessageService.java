package tv.lycam.services;

import tv.lycam.domain.Message;
import tv.lycam.domain.MessageResponse;
import tv.lycam.domain.User;

import java.util.List;



public interface MessageService {
	
	MessageResponse sendMessage(Message message);

	/***
	 * 获取房间人数
	 * @param topic
	 * @return
	 */
	List<User> getUsersByTopic(String topic);
	
}
