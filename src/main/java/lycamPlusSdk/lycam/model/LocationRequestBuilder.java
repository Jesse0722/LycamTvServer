package lycamPlusSdk.lycam.model;


import lycamPlusSdk.lycam.comm.LycamplusQueryConfig;

/**
 * @ClassName: LocationRequestBuilder 
 * @Describe: builder a custom LocationRequest
 *         
 * @Version: V0.1.0
 */
public class LocationRequestBuilder {
	
	private Float lon = null;
	private Float lat = null;
	private Float radius = null;
	private String sort;
	private String order;
	
	public LocationRequestBuilder lon(float lon) {
		this.lon = lon;
		return this;
	}
	
	public LocationRequestBuilder lat(float lat) {
		this.lat = lat;
		return this;
	}
	
	public LocationRequestBuilder radius(float radius) {
		this.radius = radius;
		return this;
	}
	
	public LocationRequestBuilder sort(LycamplusQueryConfig.QuerySort sort) {
		this.sort = sort.toString();
		return this;
	}
	
	public LocationRequestBuilder order(LycamplusQueryConfig.QueryOrder direction) {
		this.order = direction.toString();
		return this;
	}
	
	public LocationRequest build() {
		LocationRequest request = new LocationRequest();
		request.setLat(lat);
		request.setLon(lon);
		request.setOrder(order);
		request.setRadius(radius);
		request.setSort(sort);
		return request;
	}
}
