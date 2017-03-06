package lycamPlusSdk.lycam.internal;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import lycamPlusSdk.lycam.comm.LycamplusConfig;
import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;




 /**
 * @ClassName: LycamplusSearchOperation
 * @Describe: 视频流管理
 * @Version: V0.1.0
 */
public class LycamplusStreamOperation extends LycamplusOperation {
	private final static String PATH = "/streams";
	private final static String START = "/start";
	private final static String STOP = "/stop";
	private final static String PAUSE = "/pause";
	private final static String RESUME = "/resume";
	
	
	private String baseURL;
	
	public LycamplusStreamOperation() {
		baseURL = LycamplusConfig.APIURL + LycamplusConfig.VERSION + PATH;
	}
	
	/**
	 * @Name: createStream
	 * @Description: 创建自定义的视频流
	 * @Version: V0.1.0(版本号)
	 * @param stream 提交的参数
	 * @return LycamplusStream 返回视频流信息
	 */
	public LycamplusStream createStream(LycamplusStream stream) {
		HttpPost httpPost = new HttpPost(baseURL);
		if(stream != null) {
			StringEntity entity = new StringEntity(jsonUtils.obj2json(stream),"utf-8");
			httpPost.setEntity(entity);
		}
		return doOperation(httpPost, true, LycamplusStream.class);
	}

	/**
	 * @Name: findStreamById
	 * @Description: 根据视频流id查找视频
	 * @Version: V0.1.0(版本号)
	 * @param streamId 视频流id
	 * @return LycamplusStream 返回视频流信息
	 */
	public LycamplusStream findOneById(String streamId) {
		HttpGet get = new HttpGet(baseURL + "/" + streamId);
		return doOperation(get, true, LycamplusStream.class);
	}
	
	/**
	 * @Name: listStreams
	 * @Description: 查询所有视频流
	 * @Version: V0.1.0(版本号)
	 * @return ObjectListing<LycamplusStream> 返回视频流的集合
	 */
	public ObjectListing<LycamplusStream> listStreams() {
		HttpGet get = new HttpGet(baseURL);
		return doOperation(get,true,new TypeReference<ObjectListing<LycamplusStream>>() {
		});
	}
	
	/**
	 * @Name: update
	 * @Description: 更新一个视频流
	 * @Version: V0.1.0(版本号)
	 * @param stream 待更新的视频流信息
	 * @return LycamplusStream 返回更新后的视频流
	 */
	public LycamplusStream update(LycamplusStream stream) {
		HttpPut put = new HttpPut(baseURL + "/" + stream.getStreamId());
		StringEntity entity = new StringEntity(jsonUtils.obj2json(stream),"utf-8");
		put.setEntity(entity);
		return doOperation(put, true, LycamplusStream.class);
	}
	
	/**
	 * @Name: destroy
	 * @Description: 销毁一个视频流
	 * @Version: V0.1.0(版本号)
	 * @return LycamplusStream 返回更新后的视频流
	 */
	public boolean destroy(String streamId) {
		HttpDelete delete = new HttpDelete(baseURL + "/" + streamId);
		Map<String,Boolean> res = doOperation(delete,true,Map.class);
		return res.get(RETURNFLAG);
	}

	/**
	 * @Name: start
	 * @Description: 根据stream开始一个视频流
	 * @Version: V0.1.0(版本号)
	 * @param streamId 视频流的ID
	 * @return LycamplusStream 返回视频流的信息
	 */
	public LycamplusStream start(String streamId) {
		HttpPost httpPost = new HttpPost(baseURL + "/" + streamId + START);
		return doOperation(httpPost,true,LycamplusStream.class);
	}

	/**
	 * @Name: stop
	 * @Description: 根据streamId 停止一个视频直播
	 * @Version: V0.1.0(版本号)
	 * @return boolean 停止是否成功
	 */
	public boolean stop(String streamId) {
		HttpPost httpPost = new HttpPost(baseURL + "/" + streamId + STOP);
		Map<String,Boolean> res = doOperation(httpPost,true,Map.class);
		return res.get(RETURNFLAG);
	}
	
	/**
	 * @Name: pause
	 * @Description: 根据streamId 暂停一个视频直播
	 * @Version: V0.1.0(版本号)
	 * @return boolean 暂停是否成功
	 */
	public boolean pause(String streamId) {
		HttpPost httpPost = new HttpPost(baseURL + "/" + streamId + PAUSE);
		Map<String,Boolean> res = doOperation(httpPost,true,Map.class);
		return res.get(RETURNFLAG);
	}
	
	/**
	 * @Name: resume
	 * @Description: 根据streamId 恢复一个视频直播
	 * @Version: V0.1.0(版本号)
	 * @return boolean 暂停是否成功
	 */
	public boolean resume(String streamId) {
		HttpPost httpPost = new HttpPost(baseURL + "/" + streamId + RESUME);
		Map<String,Boolean> res = doOperation(httpPost,true,Map.class);
		return res.get(RETURNFLAG);
	}
	
	
}
