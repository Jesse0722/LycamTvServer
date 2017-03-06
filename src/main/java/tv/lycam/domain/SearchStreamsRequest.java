package tv.lycam.domain;

/**
 * Created by lycam on 16/4/27.
 */
public class SearchStreamsRequest {
    private String keyword;  //搜索关键字
    private int resultsPerPage;  //每页返回记录数
    private int page;  //返回第几页
    private String sort;  //排序字段(id,description,created)
    private String order;  //排序方向(asc,desc)

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
