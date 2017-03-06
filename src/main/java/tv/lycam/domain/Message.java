package tv.lycam.domain;

public class Message {
	
	private String client;

	private String receiver;
	
	private String topic;//频道
	
	private int type;//消息类型0:频道消息，1:礼物消息，2，私信
	
	private String content;
	
	private String username;
	
	private String avatarUrl;

//	private String message;
	
	private int showType;
	
	private int qos;//发送质量
	
	private int retain;//默认为0
	

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getQos() {
		return qos;
	}

	public void setQos(int qos) {
		this.qos = qos;
	}

	public int getRetain() {
		return retain;
	}

	public void setRetain(int retain) {
		this.retain = retain;
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getShowType() {
		return showType;
	}

	public void setShowType(int showType) {
		this.showType = showType;
	}

}
