package lycamPlusSdk.lycam.auth;
/**
 * @ClassName: Credentials
 * @Describe: Abstract credentials for request lycamplus API 
 * @Version: V0.1.0
 */
public interface Credentials {
	
	/**
	 * Returns the app ID for this credentials.
	 */
	public String getAppId();
	
	/**
	 * Returns the app secret for this credentials.
	 */
	public String getAppSecret();
	
	/**
	 * Returns the public access token for this credentials.
	 */
	public String getPublicAccessToken();
	
	/**
	 * Returns the private access token for this credentials.
	 */
	public String getPrivateAccessToken();
	
	/**
	 * set the private access token for this credentials.
	 */
	public void setPrivateAccessToken(String privateAccessToken);
}
