package lycamPlusSdk.lycam.auth;



/**
 * @ClassName: CredentialsProvider
 * @Describe: 公共接口，为用户提供一个Credentials，得到和设置 认证信息
 * @Version: V0.1.0
 */
public interface CredentialsProvider {
	
	public void setCredentials(Credentials creds);
	
	public Credentials getCredentials();
	
	/**
	 * @Name: initPrivateToken
	 * @Description: 根据username、password 得到 private accessToken
	 * @Version: V0.1.0
	 * @param username 
	 * @param password
	 */
	public void initPrivateToken(String username, String password);
	
	/**
	 * @Name: removePrivateToken
	 * @Description: delete private token
	 * @Version: V0.1.0
	 */
	public void removePrivateToken();
}
