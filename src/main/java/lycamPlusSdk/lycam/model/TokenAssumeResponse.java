package lycamPlusSdk.lycam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class TokenAssumeResponse {
	
	private boolean success;
	
	private String scope;
	
	private Token token = new Token();
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}	
    public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	
	public String getToken_type() {
		return token.getToken_type();
	}
	
	public String getAccess_token() {
		return token.getAccess_token();
	}
	
	public String getExpires_in() {
		return token.getExpires_in();
	}
	
	static class Token {
    	private String token_type;
    	private String access_token;
    	private String expires_in;
    	
    	public String getToken_type() {
    		return token_type;
    	}
    	public void setToken_type(String token_type) {
    		this.token_type = token_type;
    	}
    	public String getAccess_token() {
    		return access_token;
    	}
    	public void setAccess_token(String access_token) {
    		this.access_token = access_token;
    	}
    	public String getExpires_in() {
    		return expires_in;
    	}
    	public void setExpires_in(String expires_in) {
    		this.expires_in = expires_in;
    	}
	}
}	
