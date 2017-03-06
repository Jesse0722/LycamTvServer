package lycamPlusSdk.lycam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @ClassName: UserRequest 
 * @Describe: 自定义查询用户条件
 *         
 * @Version: V0.1.0
 */
@JsonInclude(Include.NON_DEFAULT)
public class UserRequest {
	/*用户名*/
	private String username;
	/*每页返回记录数*/
	private int resultsPerPage;
	/*返回第几页*/
	private int page;
	/*排序字段(id,name,created)  */
	private String sort;
	/*升序 or 降序*/
	private String order;
	
	public UserRequest() {
		
	}
	
	public UserRequest(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getResultsPerPage() {
		return resultsPerPage;
	}
	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
		
}
