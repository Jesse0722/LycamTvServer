package lycamPlusSdk.lycam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @ClassName: LycamplusStream 
 * @Describe: lycam 视频流信息
 * @Version: V0.1.0
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class LycamplusStream {
	
	
	private String user;
	
	private String streamId;
	
	private String status;
	
	private String streamUrl;
	
	private String thumbnailUrl;
	
	private String uploadUrl;
	
	private String resourceUrl;
	
	private Float startLat = null;
	
	private Float startLon = null;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private boolean privacy;
	
	private String title;
	
	private String description;

	private Object extraInfo;

	private String streamType;
		
	private String prefix;	
	
	private String streamResourceRoot;
	
	private String chatUrl;
	
	private String videoWidth;
	
	private String videoHeight;
	private String videoOrientation;
	private String timeFinished;
	private float endLat;
	private float endLon;
	//private String streamUrls;
	private int maxBitrate;
	private int maxKeyframe;
	private String timeStarted;
	private String bucketName;
	private String endpoint;
	private String protocol;
	private int segmentDurationSeconds;
	private int hlsListSize;
	private boolean useAdaptiveBitrate;
	private String region;
	//private String rtmpServerConfig;
	//private String credentials;
	private String createdAt;
	private String updatedAt;

	
	public String getStreamId() {
		return streamId;
	}
	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getStartLat() {
		return startLat;
	}
	public void setStartLat(Float startLat) {
		this.startLat = startLat;
	}
	public Float getStartLon() {
		return startLon;
	}
	public void setStartLon(Float startLon) {
		this.startLon = startLon;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public Object getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(Object extraInfo) {
		this.extraInfo = extraInfo;
	}
	public String getStreamUrl() {
		return streamUrl;
	}
	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}
	
	public void setUser(String user){
		this.user=user;
	}

	public String getUser(){
		return this.user;
	}
	
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getStreamType() {
		return streamType;
	}
	public void setStreamType(String streamType) {
		this.streamType = streamType;
	}
	
	public String getUploadUrl() {
		return uploadUrl;
	}
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}
	public boolean isPrivacy() {
		return privacy;
	}
	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}
	public String getVideoOrientation() {
		return videoOrientation;
	}
	public void setVideoOrientation(String videoOrientation) {
		this.videoOrientation = videoOrientation;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getStreamResourceRoot() {
		return streamResourceRoot;
	}
	public void setStreamResourceRoot(String streamResourceRoot) {
		this.streamResourceRoot = streamResourceRoot;
	}
	public String getChatUrl() {
		return chatUrl;
	}
	public void setChatUrl(String chatUrl) {
		this.chatUrl = chatUrl;
	}
	public String getVideoWidth() {
		return videoWidth;
	}
	public void setVideoWidth(String videoWidth) {
		this.videoWidth = videoWidth;
	}
	public String getVideoHeight() {
		return videoHeight;
	}
	public void setVideoHeight(String videoHeight) {
		this.videoHeight = videoHeight;
	}
	public String getTimeFinished() {
		return timeFinished;
	}
	public void setTimeFinished(String timeFinished) {
		this.timeFinished = timeFinished;
	}
	public float getEndLat() {
		return endLat;
	}
	public void setEndLat(float endLat) {
		this.endLat = endLat;
	}
	public float getEndLon() {
		return endLon;
	}
	public void setEndLon(float endLon) {
		this.endLon = endLon;
	}
	
	public int getMaxBitrate() {
		return maxBitrate;
	}
	public void setMaxBitrate(int maxBitrate) {
		this.maxBitrate = maxBitrate;
	}
	public int getMaxKeyframe() {
		return maxKeyframe;
	}
	public void setMaxKeyframe(int maxKeyframe) {
		this.maxKeyframe = maxKeyframe;
	}
	public String getTimeStarted() {
		return timeStarted;
	}
	public void setTimeStarted(String timeStarted) {
		this.timeStarted = timeStarted;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public int getSegmentDurationSeconds() {
		return segmentDurationSeconds;
	}
	public void setSegmentDurationSeconds(int segmentDurationSeconds) {
		this.segmentDurationSeconds = segmentDurationSeconds;
	}
	public int getHlsListSize() {
		return hlsListSize;
	}
	public void setHlsListSize(int hlsListSize) {
		this.hlsListSize = hlsListSize;
	}
	public boolean isUseAdaptiveBitrate() {
		return useAdaptiveBitrate;
	}
	public void setUseAdaptiveBitrate(boolean useAdaptiveBitrate) {
		this.useAdaptiveBitrate = useAdaptiveBitrate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
