package lycamPlusSdk.lycam.model;


import lycamPlusSdk.lycam.comm.LycamplusQueryConfig;

/**
 * @ClassName: UserRequestBuilder 
 * @Describe: builder a custom UserRequest
 *         
 * @Version: V0.1.0
 */
public class UserRequestBuilder {
	
	private String username;
	private int resultsPerPage;
	private int page;
	private String sort;
	private String order;
	
	public UserRequestBuilder username(String username) {
		this.username = username;
		return this;
	}
	
	public UserRequestBuilder resultPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
		return this;
	}
	
	public UserRequestBuilder page(int page) {
		this.page = page;
		return this;
	}
	
	public UserRequestBuilder sort(LycamplusQueryConfig.QuerySort sort) {
		this.sort = sort.toString();
		return this;
	}
	
	public UserRequestBuilder order(LycamplusQueryConfig.QueryOrder direction) {
		this.order = direction.toString();
		return this;
	}
	
	public UserRequest build() {
		UserRequest request = new UserRequest();
		request.setUsername(username);
		request.setOrder(order);
		request.setPage(page);
		request.setResultsPerPage(resultsPerPage);
		request.setSort(sort);
		return request;
	}
	
}
