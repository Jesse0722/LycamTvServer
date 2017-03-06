package tv.lycam.domain;

public class MessageBody{
	
private int type;//消息类型0:频道消息，1:礼物消息，2，私信
    
    private String content;
    
    private String receiver;
    
    private String username;
    
    private String avatarUrl;
    
    private int showType;

    private int senderBalance;

    private int anchorPopularity;

    private int onlineCount;
    
    public MessageBody(){
        
    }

    @Override
    public String toString() {
        return "content:"+content+",receiver"+receiver+",username"+username+",avatarUrl"+avatarUrl
                +",senderBalance"+senderBalance+",anchorPopularity"+anchorPopularity+",onlineCount"+onlineCount;
    }

    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public String getReceiver() {
        return receiver;
    }
    
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getAvatarUrl() {
        return avatarUrl;
    }
    
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    
    public int getShowType() {
        return showType;
    }
    
    public void setShowType(int showType) {
        this.showType = showType;
    }
    
	public MessageBody(String content,String sender,String receiver,String avatarUrl,int type,int showType){
		this.type=type;
		this.content=content;
		this.username=sender;
		this.avatarUrl=avatarUrl;
		this.showType=showType;
		this.receiver=receiver;
	}

    public int getSenderBalance() {
        return senderBalance;
    }

    public void setSenderBalance(int senderBalance) {
        this.senderBalance = senderBalance;
    }

    public int getAnchorPopularity() {
        return anchorPopularity;
    }

    public void setAnchorPopularity(int anchorPopularity) {
        this.anchorPopularity = anchorPopularity;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }



}