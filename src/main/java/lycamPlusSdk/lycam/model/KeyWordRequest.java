package lycamPlusSdk.lycam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @ClassName: KeyWordRequest 
 * @Describe: 自定义 关键字查询条件
 *         
 * @Version: V0.1.0
 */
@JsonInclude(Include.NON_DEFAULT)
public class KeyWordRequest {
	/*查询关键字*/
	private String keyword;
	/*每页返回记录数*/
	private int resultsPerPage;
	/*返回第几页*/
	private int page;
	/*排序字段(id,name,created)  */
	private String sort;
	/*升序 or 降序*/
	private String order;
	
	public KeyWordRequest(){
		
	}
	
	public KeyWordRequest(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
