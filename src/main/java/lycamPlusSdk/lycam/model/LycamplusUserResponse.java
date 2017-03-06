package lycamPlusSdk.lycam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @ClassName: LycamplusUserResponse 
 * @Describe: 创建用户返回的信息
 *         
 * @Version: V0.1.0
 */
@JsonInclude(Include.NON_DEFAULT)
public class LycamplusUserResponse {
	private String appname;
	private String username;
	private String password;
	private String uuid;
	private boolean success;
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
