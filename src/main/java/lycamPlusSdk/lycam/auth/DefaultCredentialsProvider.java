package lycamPlusSdk.lycam.auth;


/**
 * @ClassName: DefaultCredentialsProvider
 * @Describe: 实现CredentialsProvider接口的默认实体类，提供一个DefaultCredentials认证信息
 * @Version: V0.1.0
 */
public class DefaultCredentialsProvider implements CredentialsProvider {

	private volatile Credentials creds;
	private OauthValidate oAuthValidate = new OauthValidate();
	
	
	public DefaultCredentialsProvider(Credentials creds) {
		setCredentials(creds);
	}
	
	public DefaultCredentialsProvider(String appId, String appSecret) {
		checkCredentials(appId, appSecret);
		String accessToken = oAuthValidate.clientCredentialsValidate(appId, appSecret);
		setCredentials(new DefaultCredentials(appId, appSecret, accessToken,null));
	}
	
	public DefaultCredentialsProvider(String appId, String appSecret, String accessToken) {
		checkCredentials(appId, appSecret);
		setCredentials(new DefaultCredentials(appId, appSecret, accessToken,null));
	}
	
	@Override
	public synchronized void setCredentials(Credentials creds) {
		if (creds == null) {
			throw new InvalidCredentialsException("creds should not be null.");
		}
		checkCredentials(creds.getAppId(), creds.getAppSecret());	
		this.creds = creds;
	}

	@Override
	public Credentials getCredentials() {
		if (this.creds == null) {
			throw new InvalidCredentialsException("Invalid credentials");
		}
		
		return this.creds;
	}
	
	@Override
	public void initPrivateToken(String username, String password) {
		checkUser(username,password);
		String accessToken = oAuthValidate.passwordCredentialsValidate(creds,username, password);
		creds.setPrivateAccessToken(accessToken);
	}
	
	@Override
	public void removePrivateToken() {
		creds.setPrivateAccessToken("");
	}
	private static void checkCredentials(String appId, String appSecret) {
		if (appId == null || "".equals(appId)) {
            throw new InvalidCredentialsException("Access key id should not be null or empty.");
        }    
		if (appSecret == null || "".equals(appSecret)) {
            throw new InvalidCredentialsException("Secret access key should not be null or empty.");
        }
	}
	
	private static void checkUser(String username, String password) {
		if (username == null || "".equals(username)) {
            throw new InvalidCredentialsException("username should not be null or empty.");
        }    
		if (password == null || "".equals(password)) {
            throw new InvalidCredentialsException("password should not be null or empty.");
        }
	}

	
	
}
