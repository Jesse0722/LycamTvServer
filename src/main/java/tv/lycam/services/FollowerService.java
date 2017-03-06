package tv.lycam.services;



import tv.lycam.domain.Follower;
import tv.lycam.domain.User;

import java.util.List;

/**
 * Created by lycam on 16/4/29.
 */

public interface FollowerService {

    List<String> getFollowerIds(String uid);

    List<User> getFollowers(String uid);

    Follower addFollower(Follower follower);

    void subFollower(Follower follower);
    
    Follower getFollowerByUidAndFollowerId(String uid, String followerId);
    
    int getFollowersCount(String uid);
}
