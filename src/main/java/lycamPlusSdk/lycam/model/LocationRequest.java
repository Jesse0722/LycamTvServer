package lycamPlusSdk.lycam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @ClassName: LocationRequest 
 * @Describe: 基于地理位置查询条件
 *         
 * @Version: V0.1.0
 */
@JsonInclude(Include.NON_NULL)
public class LocationRequest {
	/*经度*/
	private Float lon = null;
	/*纬度*/
	private Float lat = null;
	/*半径*/
	private Float radius = null;
	/*排序字段(id,name,created)  */
	private String sort;
	/*升序 or 降序*/
	private String order;
		
	public LocationRequest() {
		
	}
	
	public LocationRequest(float lon,float lat,float radius) {
		this.lon = lon;
		this.lat = lat;
		this.radius = radius;
	}
	
	public Float getLon() {
		return lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getRadius() {
		return radius;
	}
	public void setRadius(Float radius) {
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
