package lycamPlusSdk.lycam.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @ClassName: ObjectListing<T> 
 * @Describe: 用于集合查询
 *         
 * @Version: V0.1.0
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ObjectListing<T> {
	
	private int totalItems;
	private int resultsPerPage;
	private int pageNumber;
	private boolean nextPageAvailable;
	private List<T> items;
	
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getResultsPerPage() {
		return resultsPerPage;
	}
	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public boolean isNextPageAvailable() {
		return nextPageAvailable;
	}
	public void setNextPageAvailable(boolean nextPageAvailable) {
		this.nextPageAvailable = nextPageAvailable;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	
}
