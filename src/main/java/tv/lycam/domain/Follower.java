package tv.lycam.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lycam on 16/4/29.
 */
@Document(collection = "follower")
public class Follower {
    @Id
    private String id;

    private String uid;

    private String followerId;

    public Follower(String uid,String followerId){
        this.uid=uid;
        this.followerId=followerId;
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

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }
}
