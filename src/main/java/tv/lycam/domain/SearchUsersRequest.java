package tv.lycam.domain;

/**
 * Created by lycam on 16/4/27.
 */
public class SearchUsersRequest {

    private String username; //搜索的用户名

    private String phone; //搜索的手机号码

    private int resultsPerPage; //每页返回记录数

    private int page; //返回第几页

    private String sort;//排序字段(id,name,created)

    private String order;//排序方向(asc,desc)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
