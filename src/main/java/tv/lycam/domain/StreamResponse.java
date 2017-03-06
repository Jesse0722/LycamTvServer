package tv.lycam.domain;

/**
 * Created by jesse on 2017/3/4.
 */
public class StreamResponse {
    public String getStreamId() {
        return streamId;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getStreamUrl() {
        return streamUrl;
    }
    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    public String getResourceUrl() {
        return resourceUrl;
    }
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
    public String getStreamResourceRoot() {
        return streamResourceRoot;
    }
    public void setStreamResourceRoot(String streamResourceRoot) {
        this.streamResourceRoot = streamResourceRoot;
    }
    public String getStreamType() {
        return streamType;
    }
    public void setStreamType(String streamType) {
        this.streamType = streamType;
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
    public String getVideoOrientation() {
        return videoOrientation;
    }
    public void setVideoOrientation(String videoOrientation) {
        this.videoOrientation = videoOrientation;
    }
    public String getTimeStarted() {
        return timeStarted;
    }
    public void setTimeStarted(String timeStarted) {
        this.timeStarted = timeStarted;
    }
    public String getTimeFinished() {
        return timeFinished;
    }
    public void setTimeFinished(String timeFinished) {
        this.timeFinished = timeFinished;
    }
    public float getStartLat() {
        return startLat;
    }
    public void setStartLat(float startLat) {
        this.startLat = startLat;
    }
    public float getStartLon() {
        return startLon;
    }
    public void setStartLon(float startLon) {
        this.startLon = startLon;
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
    public boolean isPrivacy() {
        return privacy;
    }
    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
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
    public String getExtraInfo() {
        return extraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    public String getStreamUrls() {
        return streamUrls;
    }
    public void setStreamUrls(String streamUrls) {
        this.streamUrls = streamUrls;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    private String user;

    public void setStreamId(String streamId) {
        this.streamId = streamId;
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

    private String streamId;

    private String status;

    private String prefix;

    private String streamUrl;

    private String thumbnailUrl;

    private String resourceUrl;

    private String streamResourceRoot;

    private String streamType;

    private String chatUrl;

    private String videoWidth;

    private String videoHeight;
    private String videoOrientation;
    private String timeFinished;
    private float startLat;
    private float startLon;
    private float endLat;
    private float endLon;
    private String city;
    private String state;
    private String country;
    private boolean privacy;
    private String title;
    private String description;
    private String extraInfo;
    private String streamUrls;
    private int maxBitrate;
    private int maxKeyframe;
    private String timeStarted;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private String endpoint;

    private String credentials;

    private boolean deleted;

    private String createdAt;
    private String updatedAt;
    private boolean active;


    public String getRtmpServerConfig() {
        return rtmpServerConfig;
    }

    public void setRtmpServerConfig(String rtmpServerConfig) {
        this.rtmpServerConfig = rtmpServerConfig;
    }

    private String rtmpServerConfig;

}
