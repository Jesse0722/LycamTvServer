package lycamPlusSdk.lycam.internal;



import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import lycamPlusSdk.lycam.comm.LycamplusConfig;
import lycamPlusSdk.lycam.model.LycamplusUser;
import lycamPlusSdk.lycam.model.LycamplusUserResponse;
import lycamPlusSdk.lycam.model.ObjectListing;
import lycamPlusSdk.lycam.model.TokenAssumeResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import static lycamPlusSdk.lycam.utils.CodingUtils.checkParamIsNullOrEmpty;


/**
 * @ClassName: LycamPlusUserOperation
 * @Describe: 用户管理
 * @Version: V0.1.0
 */
public class LycamplusUserOperation extends LycamplusOperation {
	
	private final static String PATH = "/users";
	private final static String ACCOUNT = "/account";
	private final static String LOGOUT = "/logout";
	private final static String ASSUME = "/assume";
	private String baseUrl;
	
	public LycamplusUserOperation() {
		baseUrl = LycamplusConfig.APIURL + LycamplusConfig.VERSION;
	}
	/**
	 * @Name: createUser
	 * @Description: 创建用户
	 * @Version: V0.1.0
	 * @param user 用户相关参数
	 * @return LycamPlusUserResponse 返回状态
	 */
	public LycamplusUserResponse createUser(LycamplusUser user) {
		HttpPost httpPost = new HttpPost(baseUrl + PATH);
		StringEntity entity = new StringEntity(jsonUtils.obj2json(user),"utf-8");
		httpPost.setEntity(entity);
		return doOperation(httpPost, false, LycamplusUserResponse.class);
	}
	
	public LycamplusUserResponse createUser() {
		HttpPost httpPost = new HttpPost(baseUrl + PATH);
		return doOperation(httpPost, false, LycamplusUserResponse.class);
	}
	
	/**
	 * @Name: logout
	 * @Description: 用户安全退出
	 * @Version: V0.1.0
	 * @return boolean 是否成功
	 */
	public boolean logout() {
		HttpDelete delete = new HttpDelete(baseUrl + ACCOUNT + LOGOUT);
		Map<String,Boolean> res = doOperation(delete,true,Map.class);
		if(res.get(RETURNFLAG)) {
			credentialsProvider.removePrivateToken();
		}
		return res.get(RETURNFLAG);
	}
	
	/**
	 * @Name: getCurrentUser
	 * @Description: 得到当前用户
	 * @Version: V0.1.0
	 * @return LycamPlusUser 返回 用户信息
	 */
	public LycamplusUser getCurrentUser() {
		HttpGet httpGet = new HttpGet(baseUrl + ACCOUNT);
		return doOperation(httpGet, true, LycamplusUser.class);
	}
	
	/**
	 * @Name: updateCurrentUser
	 * @Description: 更新用户信息
	 * @Version: V0.1.0
	 * @param user 待更新的用户信息
	 */
	public LycamplusUser updateCurrentUser(LycamplusUser user) {
		HttpPut httpPut = new HttpPut(baseUrl + ACCOUNT);
		StringEntity entity = new StringEntity(jsonUtils.obj2json(user),"utf-8");
		httpPut.setEntity(entity);
		return doOperation(httpPut,true,LycamplusUser.class);
	}
	
	/**
	 * @Name: resetPassWord
	 * @Description: 重置密码
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @return newPassword 新密码
	 */
	public void resetPassWord(String uuid, String newPassword) {
		HttpPut httpPut = new HttpPut(baseUrl + PATH + "/" +uuid +"/password");
		
		Map<String,String> paramsMap = new HashMap<String, String>();
		paramsMap.put("password",newPassword);
		String params = jsonUtils.obj2json(paramsMap);
		StringEntity entity = new StringEntity(params,"utf-8");
		httpPut.setEntity(entity);
		
		doOperation(httpPut,true,LycamplusUser.class);	
	}
	
	/**
	 * @Name: findOneById
	 * @Description: 根据uuid查询用户
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @return LycamPlusUser 用户信息
	 */
	public LycamplusUser findOneById(String uuid) {
		HttpGet httpGet = new HttpGet(baseUrl + PATH + "/" +uuid);
		return doOperation(httpGet,true,LycamplusUser.class);
	}
	
	/**
	 * @Name: listUsers
	 * @Description: 查询所有用户
	 * @Version: V0.1.0
	 * @return ObjectListing<LycamplusUser> 返回用户列表
	 */
	public ObjectListing<LycamplusUser> listUsers() {
		HttpGet httpGet = new HttpGet(baseUrl + PATH);
		
		return doOperation(httpGet, true, new TypeReference<ObjectListing<LycamplusUser>>() {
		});
	}
	
	/**
	 * @Name: getUserTokenById
	 * @Description: 获取用户授权token
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @return TokenResumeResponse 返回token信息
	 */
	public TokenAssumeResponse getUserTokenById(String uuid, String scope, Integer durationSeconds) {
		HttpPost post = new HttpPost(baseUrl + PATH + "/" + uuid + ASSUME );
		
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		
		if( !checkParamIsNullOrEmpty(scope) ) {
			paramsMap.put("scope",scope);
		}
		
		if(durationSeconds !=null){
			paramsMap.put("durationSeconds",durationSeconds);
		}
		
		if(paramsMap.size() > 0 ) {
			String params = jsonUtils.obj2json(paramsMap);
			StringEntity entity = new StringEntity(params,"utf-8");
			post.setEntity(entity);
		}	
		
		return doOperation(post, true, TokenAssumeResponse.class);
	}


	
	
}
