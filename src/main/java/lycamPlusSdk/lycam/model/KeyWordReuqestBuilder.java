package lycamPlusSdk.lycam.model;


import lycamPlusSdk.lycam.comm.LycamplusQueryConfig;

/**
 * @ClassName: KeyWordReuqestBuilder 
 * @Describe: builder a custom KeyWordReuqest
 *         
 * @Version: V0.1.0
 */
public class KeyWordReuqestBuilder {
	
	private String keyword;
	private int resultsPerPage;
	private int page;
	private String sort;
	private String order;
	
	public KeyWordReuqestBuilder keyword(String keyword) {
		this.keyword = keyword;
		return this;
	}
	
	public KeyWordReuqestBuilder resultPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
		return this;
	}
	
	public KeyWordReuqestBuilder page(int page) {
		this.page = page;
		return this;
	}
	
	public KeyWordReuqestBuilder sort(LycamplusQueryConfig.QuerySort sort) {
		this.sort = sort.toString();
		return this;
	}
	
	public KeyWordReuqestBuilder order(LycamplusQueryConfig.QueryOrder direction) {
		this.order = direction.toString();
		return this;
	}
	
	public KeyWordRequest build() {
		KeyWordRequest request = new KeyWordRequest();
		request.setKeyword(keyword);
		request.setOrder(order);
		request.setPage(page);
		request.setResultsPerPage(resultsPerPage);
		request.setSort(sort);
		return request;
	}
	
}
