package tv.lycam.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lycam on 16/4/29.
 */
@Document(collection = "friend")
public class Friend {
    @Id
    private String id;

    private String uid;

    private String friendId;
    public Friend(){
    	
    }
    public Friend(String uid,String fid){
        this.uid=uid;
        this.friendId=fid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
