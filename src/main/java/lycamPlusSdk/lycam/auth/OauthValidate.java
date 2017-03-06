package lycamPlusSdk.lycam.auth;

import java.io.IOException;



import com.google.api.client.auth.oauth2.ClientCredentialsTokenRequest;
import com.google.api.client.auth.oauth2.PasswordTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import lycamPlusSdk.lycam.comm.LycamplusConfig;

/**
 * @ClassName: OauthValidate
 * @Describe: Oauth2认证
 * @Version: V0.1.0
 */
public class OauthValidate {
	public void clientCredentialsValidate(Credentials creds){
		this.clientCredentialsValidate(creds.getAppId(), creds.getAppSecret());
	}
	/**
	 * @Name: clientCredentialsValidate
	 * @Description: 根据appId、appSecret得到accessToken
	 * @Version: V0.1.0
	 * @param appId 
	 * @param appSecret 
	 */
	public String clientCredentialsValidate(String appId,String appSecret) {
		String accessToken = null;
		try {
			TokenResponse response =
			      new ClientCredentialsTokenRequest(new NetHttpTransport(), new JacksonFactory(),
			          new GenericUrl(LycamplusConfig.AUTH2URL + LycamplusConfig.TOKENPATH))
			          .setClientAuthentication(
			              new BasicAuthentication(appId, appSecret)).execute();
			accessToken = response.getAccessToken();
		} catch (IOException e) {		
			e.printStackTrace();
		} finally { 
			
		}
		return accessToken;
	}
	
	/**
	 * @Name: passwordCredentialsValidate
	 * @Description: 根据username、password得到private accessToken
	 * @Version: V0.1.0
	 * @param creds 
	 * @param username 
	 * @param password
	 */
	public String passwordCredentialsValidate(Credentials creds, String username, String password) {
		try {
			TokenResponse response =
			      new PasswordTokenRequest(new NetHttpTransport(), new JacksonFactory(),
			          new GenericUrl(LycamplusConfig.AUTH2URL + LycamplusConfig.TOKENPATH), username, password)
			          .setClientAuthentication(
			              new BasicAuthentication(creds.getAppId(), creds.getAppSecret()))
			          .execute();
			return response.getAccessToken();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			
		}  	
		return null;
	}
}
