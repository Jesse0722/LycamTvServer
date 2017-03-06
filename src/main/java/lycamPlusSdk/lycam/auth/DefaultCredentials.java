package lycamPlusSdk.lycam.auth;



/**
 * @ClassName: DefaultCredentials
 * @Describe: Oauth认证信息
 * @Version: V0.1.0
 */
public class DefaultCredentials implements Credentials {

	private String appId;
	private String appSecret;
	private String publicAccessToken;
	private String privateAccessToken;
	
	public DefaultCredentials(String appId,String appSecret){
		 this(appId,appSecret,null,null);
	}
	
	public DefaultCredentials(String appId,String appSecret,String publicAccessToken,String privateAccessToken){
		 if (appId == null || "".equals(appId)) {
	            throw new InvalidCredentialsException("app id should not be null or empty.");
	        }
		 if (appSecret == null || "".equals(appSecret)) {
	            throw new InvalidCredentialsException("app secret should not be null or empty.");
	        }
		 this.appId = appId;
		 this.appSecret = appSecret;
		 this.publicAccessToken = publicAccessToken;
		 this.privateAccessToken = privateAccessToken;
	}
	
	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public String getAppSecret() {	
		return appSecret;
	}

	@Override
	public String getPublicAccessToken() {
		return publicAccessToken;
	}

	@Override
	public String getPrivateAccessToken() {
		return privateAccessToken;
	}

	@Override
	public void setPrivateAccessToken(String privateAccessToken) {
		this.privateAccessToken = privateAccessToken;
	}
	
}
