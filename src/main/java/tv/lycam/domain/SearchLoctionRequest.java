package tv.lycam.domain;

/**
 * Created by lycam on 16/4/27.
 */
public class SearchLoctionRequest {

    private float lon ;//经度

    private float lat ;//维度

    private float radius; //搜索半径

    private String sort; //	排序字段(id,description,created)

    private String order;//排序方向(asc,desc)

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
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
