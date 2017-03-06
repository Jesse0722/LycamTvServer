package lycamPlusSdk.lycam.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import lycamPlusSdk.lycam.comm.LycamplusConfig;
import lycamPlusSdk.lycam.model.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;



/**
 * @ClassName: LycamplusSearchOperation
 * @Describe: 查询
 * @Version: V0.1.0
 */
public class LycamplusSearchOperation extends LycamplusOperation {
	private final static String PATH = "/search";
	private final static String USER = "/user";
	private final static String LOCATION = "/location";
	private final static String SINCE = "/streams/since/0";
	
	private	String baseUrl;
	
	public LycamplusSearchOperation() {
		baseUrl = LycamplusConfig.APIURL + LycamplusConfig.VERSION + PATH;
	}
	
	public ObjectListing<LycamplusStream> keyWordQuery(KeyWordRequest request) {
		HttpPost post = new HttpPost(baseUrl);
		StringEntity entity = new StringEntity(jsonUtils.obj2json(request),"utf-8");
		post.setEntity(entity);
		return doOperation(post,false,new TypeReference<ObjectListing<LycamplusStream>>() {
		});
	}

	public ObjectListing<LycamplusUser> userQuery(UserRequest request) {
		HttpPost post = new HttpPost(baseUrl + USER);
		StringEntity entity = new StringEntity(jsonUtils.obj2json(request),"utf-8");
		post.setEntity(entity);
		return doOperation(post,false,new TypeReference<ObjectListing<LycamplusUser>>() {
		});
	}
	
	public ObjectListing<LycamplusStream> locationQuery(LocationRequest request) {
		HttpPost post = new HttpPost(baseUrl + LOCATION);
		StringEntity entity = new StringEntity(jsonUtils.obj2json(request),"utf-8");
		post.setEntity(entity);
		return doOperation(post,false,new TypeReference<ObjectListing<LycamplusStream>>() {
		});
	}
	
	public ObjectListing<LycamplusStream> sinceQuery(){
		HttpGet post = new HttpGet(LycamplusConfig.APIURL + LycamplusConfig.VERSION + SINCE);
		//StringEntity entity = new StringEntity(jsonUtils.obj2json(request),"utf-8");
	//	post.setEntity(entity);
		return doOperation(post,true,new TypeReference<ObjectListing<LycamplusStream>>() {
		});
	}

}
