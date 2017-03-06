package lycamPlusSdk.lycam.model;


/**
 * @ClassName: LycamplusUserBuilder 
 * @Describe: builder a custom LycamplusUser
 *         
 * @Version: V0.1.0
 */
public class LycamplusUserBuilder {
	
	private String username;
	private String password;
	private String email;
	private String displayName;
	private Object extraInfo;
	
	public LycamplusUserBuilder username(String username){
		this.username = username;
		return this;
	}
	
	public LycamplusUserBuilder password(String password){
		this.password = password;
		return this;
	}
	
	public LycamplusUserBuilder email(String email){
		this.email = email;
		return this;
	}
	
	public LycamplusUserBuilder displayName(String displayName){
		this.displayName = displayName;
		return this;
	}
	
	public LycamplusUserBuilder extraInfo(Object extraInfo){
		this.extraInfo = extraInfo;
		return this;
	}
	
	public LycamplusUser build() {
		LycamplusUser user = new LycamplusUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setDisplayName(displayName);
		user.setEmail(email);
		user.setExtraInfo(extraInfo);
		return user;
	}
}
