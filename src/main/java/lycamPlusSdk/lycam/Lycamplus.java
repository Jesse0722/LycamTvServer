package lycamPlusSdk.lycam;

import lycamPlusSdk.lycam.model.*;

/**
 * @ClassName: Lycamplus 
 * @Describe: 移动视频直播服务提供者 lycam 的访问接口
 *     
 * @Version: V0.1.0
 */
public interface Lycamplus {
	
	/**
	 * @Name: login
	 * @Description: 用户登录
	 * @Version: V0.1.0
	 * @param username 用户名
	 * @param password 密码
	 */
	public void login(String username, String password);
	
	/**
	 * @Name: logout
	 * @Description: 用户安全退出
	 * @Version: V0.1.0
	 * @return boolean 是否成功
	 */
	public boolean logout();
	
	/**
	 * @Name: createUser
	 * @Description: 创建一个自定义用户
	 * @Version: V0.1.0
	 * @param user 用户相关参数
	 * @return LycamPlusUserResponse 返回创建用户的信息
	 */
	public LycamplusUserResponse createUser();
	
	/**
	 * @Name: createUser
	 * @Description: 创建默认用户
	 * @Version: V0.1.0
	 * @return LycamPlusUserResponse 返回创建用户的信息
	 */
	public LycamplusUserResponse createUser(LycamplusUser user);
	
	/**
	 * @Name: getCurrentUser
	 * @Description: 得到当前用户
	 * @Version: V0.1.0
	 * @return LycamPlusUser 返回用户实体类
	 */
	public LycamplusUser getCurrentUser();
	
	/**
	 * @Name: updateCurrentUser
	 * @Description: 更新当前用户
	 * @Version: V0.1.0
	 * @param user 需要更新的用户信息
	 * @return LycamplusUser 返回更新后的用户信息
	 */
	public LycamplusUser updateCurrentUser(LycamplusUser user);

	/**
	 * @Name: resetPassWord
	 * @Description: 重置密码
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @param newPassword 新密码
	 */
	public void resetPassWord(String uuid, String newPassword);
	
	/**
	 * @Name: findUserById
	 * @Description: 根据uuid查询用户
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @return LycamPlusUser 用户信息
	 */
	public LycamplusUser findUserById(String uuid);
	
	/**
	 * @Name: listUsers
	 * @Description: 查询所有用户
	 * @Version: V0.1.0
	 * @return ObjectListing<LycamplusUser> 返回用户列表
	 */
	public ObjectListing<LycamplusUser> listUsers();
	
	/**
	 * @Name: getUserTokenById
	 * @Description: 获取用户授权token
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @return TokenResumeResponse 返回token信息
	 */
	public TokenAssumeResponse getUserTokenById(String uuid);
	
	/**
	 * @Name: getUserTokenById
	 * @Description: 获取用户授权token
	 * @Version: V0.1.0
	 * @param uuid 用户id
	 * @param scope 授权资源范围  默认*
	 * @param durationSeconds 令牌时效（秒） 
	 * @return TokenResumeResponse 返回token信息
	 */
	public TokenAssumeResponse getUserTokenById(String uuid, String scope, Integer durationSeconds);
	/**
	 * @Name: createStream
	 * @Description: 创建一个默认的视频流
	 * @Version: V0.1.0
	 * @return LycamplusStream 返回视频流信息
	 */
	
	public LycamplusStream createStream();
	
	/**
	 * @Name: createStream
	 * @Description: 创建自定义的视频流
	 * @Version: V0.1.0
	 * @param stream 提交的参数
	 * @return LycamplusStream 返回视频流信息
	 */
	public LycamplusStream createStream(LycamplusStream stream);
	
	/**
	 * @Name: findStreamById
	 * @Description: 根据视频流id查找视频
	 * @Version: V0.1.0
	 * @param streamId 视频流id
	 * @return LycamplusStream 返回视频流信息
	 */
	public LycamplusStream findStreamById(String streamId);
	 
	
	/**
	 * @Name: listStreams
	 * @Description: 查询所有streams
	 * @Version: V0.1.0
	 * @return ObjectListing 返回视频流的集合
	 */
	public ObjectListing<LycamplusStream> listStreams();
	
	/**
	 * @Name: updateStream
	 * @Description: 更新一个视频流
	 * @Version: V0.1.0
	 * @return LycamplusStream 返回更新后的视频流
	 */
	public LycamplusStream updateStream(LycamplusStream stream);
	
	/**
	 * @Name: destroyStream
	 * @Description: 销毁一个视频流
	 * @Version: V0.1.0
	 * @return LycamplusStream 返回更新后的视频流
	 */
	public boolean destroyStream(String streamId);
	
	/**
	 * @Name: createOrUpdateStream
	 * @Description: 创建或更新一个视频流
	 * @Version: V0.1.0
	 * @param stream 待创建或更新的视频流
	 * @return LycamplusStream 返回更新后的视频流
	 */
	public LycamplusStream createOrUpdateStream(LycamplusStream stream);
	
	/**
	 * @Name: startStream
	 * @Description: 根据streamId开始一个视频流
	 * @Version: V0.1.0
	 * @return LycamplusStream 返回视频流的信息
	 */
	public LycamplusStream startStream(String streamId);
	
	/**
	 * @Name: startStream
	 * @Description: 根据streamId 开始一个视频直播
	 * @Version: V0.1.0
	 * @return LycamplusStream 返回视频流的信息
	 */
	public LycamplusStream startStream(LycamplusStream stream);
	
	/**
	 * @Name: stopStream
	 * @Description: 根据streamId 停止一个视频直播
	 * @Version: V0.1.0
	 * @return boolean 停止是否成功
	 */
	public boolean stopStream(String streamId);
	
	/**
	 * @Name: pauseStream
	 * @Description: 根据streamId 暂停一个视频直播
	 * @Version: V0.1.0
	 * @return boolean 暂停是否成功
	 */
	public boolean pauseStream(String streamId);
	
	/**
	 * @Name: resumeStream
	 * @Description: 根据streamId 恢复已经暂停的视频直播
	 * @Version: V0.1.0
	 * @param streamId 视频流的唯一标识符
	 * @return boolean 暂停是否成功
	 */
	public boolean resumeStream(String streamId);
	
	/**
	 * @Name: keyWordQuery
	 * @Description: 根据 关键字 、按照默认的排序方式查询视频流
	 * @Version: V0.1.0
	 * @param keyWord 查询的关键字
	 * @return ObjectListing<LycamplusStream> 返回的视频流集合
	 */
	public ObjectListing<LycamplusStream> keyWordQuery(String keyWord);
	
	/**
	 * @Name: keyWordQuery
	 * @Description: 根据 关键字 、按照自定义的排序方式查询视频流
	 * @Version: V0.1.0
	 * @param request 自定义的请求参数
	 * @return ObjectListing<LycamplusStream> 返回的视频流集合
	 */
	public ObjectListing<LycamplusStream> keyWordQuery(KeyWordRequest request);
	
	/**
	 * @Name: UserQuery
	 * @Description: 根据 用户名 、按照默认的排序方式查询用户
	 * @Version: V0.1.0
	 * @param username 搜索的用户名
	 * @return ObjectListing<LycamplusUser> 返回的用户列表
	 */
	public ObjectListing<LycamplusUser> UserQuery(String username);
	
	/**
	 * @Name: UserQuery
	 * @Description: 根据 用户名 、按照自定义的排序方式查询用户
	 * @Version: V0.1.0
	 * @param request 自定义的搜索参数
	 * @return ObjectListing<LycamplusUser> 返回的用户列表
	 */
	public ObjectListing<LycamplusUser> UserQuery(UserRequest request);
	
	/**
	 * @Name: LocationQuery
	 * @Description: 基于地理位置的视频搜索
	 * @Version: V0.1.0
	 * @param lon 纬度
	 * @param lat 经度
	 * @param radius 搜索半径
	 * @return ObjectListing<LycamplusStream> 返回的视频列表
	 */
	public ObjectListing<LycamplusStream> locationQuery(float lon, float lat, float radius);
	
	/**
	 * @Name: LocationQuery
	 * @Description: 基于地理位置的视频搜索
	 * @Version: V0.1.0
	 * @param request 自定义的搜索参数
	 * @return ObjectListing<LycamplusStream> 返回的视频列表
	 */
	public ObjectListing<LycamplusStream> locationQuery(LocationRequest request);
	
	
	/**
	 * @Name: SinQuery
	 * @Description: 基于时间戳的视频搜索
	 * @Version: V0.1.0
	 * @param request 根据时间戳来获取视频流
	 * @return ObjectListing<LycamplusStream> 返回的视频列表
	 */
	public ObjectListing<LycamplusStream> sinceQuery();

	/**
	 * 关闭Client实例，并释放所有正在使用的资源。
	 * 一旦关闭，将不再处理任何发送的请求。
	 */
	public void shutdown();
}
