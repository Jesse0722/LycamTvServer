package lycamPlusSdk.lycam.model;


/**
 * @ClassName: LycamplusStreamBuilder 
 * @Describe: build a LycamplusStream
 * @Version: V0.1.0
 */

public class LycamplusStreamBuilder {
	
	private Float startLat = null;
	private Float startLon = null;
	private String city;
	private String state;
	private String country;
	private Boolean isPrivate = null;
	private String title;
	private String description;
	private String thumbnailUrl;
	private Object extraInfo;
	
	public LycamplusStreamBuilder startLat(Float startLat) {
		this.startLat = startLat;
		return this;
	}
	
	public LycamplusStreamBuilder startLon(Float startLon) {
		this.startLon = startLon;
		return this;
	}

	public LycamplusStreamBuilder city(String city) {
		this.city = city;
		return this;
	}
	
	public LycamplusStreamBuilder state(String state) {
		this.state = state;
		return this;
	}
	
	public LycamplusStreamBuilder country(String country) {
		this.country = country;
		return this;
	}
	
	public LycamplusStreamBuilder isPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
		return this;
	}
	
	public LycamplusStreamBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public LycamplusStreamBuilder description(String description) {
		this.description = description;
		return this;
	}

	public LycamplusStreamBuilder thumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
		return this;
	}

	public LycamplusStreamBuilder extraInfo(Object extraInfo) {
		this.extraInfo = extraInfo;
		return this;
	}
	
	public LycamplusStream builder() {
		LycamplusStream lycamPlusStream = new LycamplusStream();
		lycamPlusStream.setPrivacy(isPrivate);
		lycamPlusStream.setCity(city);
		lycamPlusStream.setCountry(country);
		lycamPlusStream.setDescription(description);
		lycamPlusStream.setExtraInfo(extraInfo);
		lycamPlusStream.setStartLat(startLat);
		lycamPlusStream.setStartLon(startLon);
		lycamPlusStream.setState(state);
		lycamPlusStream.setThumbnailUrl(thumbnailUrl);
		lycamPlusStream.setTitle(title);
		return lycamPlusStream;
	}
	
}
