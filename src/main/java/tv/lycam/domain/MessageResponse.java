package tv.lycam.domain;

/**
 * Created by lycam on 16/4/27.
 */
public class MessageResponse {

    private String messageId;

    private boolean success;


    
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
