package lycamPlusSdk.lycam;


import lycamPlusSdk.lycam.auth.CredentialsProvider;
import lycamPlusSdk.lycam.auth.DefaultCredentialsProvider;
import lycamPlusSdk.lycam.comm.HttpConnectManager;
import lycamPlusSdk.lycam.comm.LycamplusConfig;
import lycamPlusSdk.lycam.internal.LycamplusSearchOperation;
import lycamPlusSdk.lycam.internal.LycamplusStreamOperation;
import lycamPlusSdk.lycam.internal.LycamplusUserOperation;
import lycamPlusSdk.lycam.model.*;
import org.apache.log4j.Logger;

import static lycamPlusSdk.lycam.utils.CodingUtils.*;

/**
 * @ClassName: LycamplusClient 
 * @Describe: 访问 lycamplus API 的 入口类
 *     
 * @Version: V0.1.0
 */
public class LycamplusClient implements Lycamplus {
	
	private static Logger logger = Logger.getLogger(LycamplusClient.class);
	/* The default credentials provider */
	private CredentialsProvider credentialsProvider;
	
	/* The miscellaneous lycam operations */
	private LycamplusUserOperation userOperation;
	private LycamplusStreamOperation streamOperation;
	private LycamplusSearchOperation searchOperation;
	
	/**
	 * 使用lycam颁发的 appKey 和 appSecret 构造一个新的 LycamPlusClient 对象
	 * 
	 * @param appKey 访问 lycam 的 app Key ID
	 * @param appSecret 访问 lycam 的 app Key secret
	 */
	public LycamplusClient(String appId,String appSecret) {
		this.credentialsProvider = (CredentialsProvider) new DefaultCredentialsProvider(appId,appSecret);
		initOepration();		
	}
	
	
	@Override
	public void login(String username, String password) {
		credentialsProvider.initPrivateToken(username,password);
		initCredentialsProvider();
		
	}

	private void initOepration() {
		userOperation = new LycamplusUserOperation();
		streamOperation = new LycamplusStreamOperation();
		searchOperation = new LycamplusSearchOperation();
		searchOperation.setCredentialsProvider(credentialsProvider);	
	}

	private void initCredentialsProvider() {
		userOperation.setCredentialsProvider(credentialsProvider);
		streamOperation.setCredentialsProvider(credentialsProvider);
		searchOperation.setCredentialsProvider(credentialsProvider);	
	}
	
	@Override
	public boolean logout() {
		/*若未登录*/
		if(checkParamIsNullOrEmpty(credentialsProvider.getCredentials().getPrivateAccessToken())) {
			if(logger.isDebugEnabled()) {
				logger.debug("you haven't login, Please log in first...");
			}
			return false;
		} else {
			return userOperation.logout();
		}
		
	}
	
	@Override
	public LycamplusUserResponse createUser() {
		return userOperation.createUser();
	}

	@Override
	public LycamplusUserResponse createUser(LycamplusUser user) {
		assertParameterNotNull(user, "user");
		String pwd = user.getPassword();
		/*密码非空则校验*/
		if( !checkParamIsNullOrEmpty(pwd) ) {
			assertParameterInRange(pwd.length(),"password", LycamplusConfig.PASSWORD_LOWER, LycamplusConfig.PASSWORD_UPPER);
		}
		return userOperation.createUser(user);
	}
	
	@Override
	public LycamplusUser getCurrentUser() {
		return userOperation.getCurrentUser();
	}
	
	@Override
	public LycamplusUser updateCurrentUser(LycamplusUser user) {
		assertParameterNotNull(user, "user");
		assertParameterNotNull(user.getUuid(), "User's uuid");
		return userOperation.updateCurrentUser(user);
	}
	
	@Override
	public void resetPassWord(String uuid, String newPassword) {
		assertStringNotNullOrEmpty(uuid,"uuid");
		assertStringNotNullOrEmpty(newPassword,"password");
		assertParameterInRange(newPassword.length(),"password",LycamplusConfig.PASSWORD_LOWER, LycamplusConfig.PASSWORD_UPPER);
		userOperation.resetPassWord(uuid,newPassword);
	}
	
	@Override
	public LycamplusUser findUserById(String uuid) {
		assertStringNotNullOrEmpty(uuid,"uuid");
		return userOperation.findOneById(uuid);
	}
	
	@Override
	public ObjectListing<LycamplusUser> listUsers() {
		return userOperation.listUsers();
	}
	
	@Override
	public TokenAssumeResponse getUserTokenById(String uuid) {
		assertStringNotNullOrEmpty(uuid, "uuid");
		return userOperation.getUserTokenById(uuid,null,null);
	}
	
	@Override
	public TokenAssumeResponse getUserTokenById(String uuid, String scope,
												Integer durationSeconds) {
		assertStringNotNullOrEmpty(uuid, "uuid");
		return userOperation.getUserTokenById(uuid, scope, durationSeconds);
	}

	@Override
	public LycamplusStream createStream() {
		return this.createStream(null);
	}
	
	@Override
	public LycamplusStream createStream(LycamplusStream stream) {
		return streamOperation.createStream(stream);
	}
	
	@Override
	public LycamplusStream updateStream(LycamplusStream stream) {
		assertStringNotNullOrEmpty(stream.getStreamId(),"streamId");
		return streamOperation.update(stream);
	}
	
	@Override
	public boolean destroyStream(String streamId) {
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.destroy(streamId);
	}

	@Override
	public LycamplusStream createOrUpdateStream(LycamplusStream stream) {
		assertParameterNotNull(stream, "stream");
		if(checkParamIsNullOrEmpty(stream.getStreamId())) {
			return createStream(stream);
		} else {
			return streamOperation.update(stream);
		}	
	}
	
	@Override
	public LycamplusStream findStreamById(String streamId) {
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.findOneById(streamId);
	}
	
	@Override
	public ObjectListing<LycamplusStream> listStreams() {
		
		return streamOperation.listStreams();
	}
	
	@Override
	public LycamplusStream startStream(String streamId) {
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.start(streamId);
	}
	
	@Override
	public LycamplusStream startStream(LycamplusStream stream) {
		assertParameterNotNull(stream,"LycamplusStream");
		if(stream.getStreamId() == null || "".equals(stream)) {
			//若不存在，则创建
			stream = createStream(stream);
		} 
		String streamId = stream.getStreamId();
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.start(streamId);
	}
	
	@Override
	public boolean stopStream(String streamId) {
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.stop(streamId);
	}
	
	@Override
	public boolean pauseStream(String streamId) {
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.pause(streamId);
	}
	
	@Override
	public boolean resumeStream(String streamId) {
		assertStringNotNullOrEmpty(streamId,"streamId");
		return streamOperation.resume(streamId);
	}
	
	@Override
	public ObjectListing<LycamplusStream> keyWordQuery(String keyWord) {
		assertStringNotNullOrEmpty(keyWord,"keyWord");
		return keyWordQuery(new KeyWordRequest(keyWord));
	}
	
	@Override
	public ObjectListing<LycamplusStream> keyWordQuery(KeyWordRequest request) {
		assertParameterNotNull(request, "request");
		return searchOperation.keyWordQuery(request);
	}
	@Override
	public ObjectListing<LycamplusUser> UserQuery(String username) {
		assertStringNotNullOrEmpty(username, "username");
		return UserQuery(new UserRequest(username));
	}
	@Override
	public ObjectListing<LycamplusUser> UserQuery(UserRequest request) {
		assertParameterNotNull(request, "request");
		return searchOperation.userQuery(request);
	}
	@Override
	public ObjectListing<LycamplusStream> locationQuery(float lon, float lat,
			float radius) {		
		return locationQuery(new LocationRequest(lon, lat, radius));
	}
	@Override
	public ObjectListing<LycamplusStream> locationQuery(LocationRequest request) {
		assertParameterNotNull(request, "request");
		return searchOperation.locationQuery(request);
	}


	@Override
	public void shutdown() {
		HttpConnectManager.release();
	}


	@Override
	public ObjectListing<LycamplusStream> sinceQuery() {
		//assertParameterNotNull(request, "request");
		return searchOperation.sinceQuery();
	}
	
	
}
