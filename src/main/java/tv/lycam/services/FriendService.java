package tv.lycam.services;


import tv.lycam.domain.Friend;
import tv.lycam.domain.ResultResponse;
import tv.lycam.domain.User;

import java.util.List;

/**
 * Created by lycam on 16/4/29.
 */
public interface FriendService {
    List<String> getFriendsIds(String uid);

    List<User> getFriends(String uid);

    ResultResponse addFriend(String uid, String fid);

    ResultResponse subFriend(String uid, String fid);
    
    Friend getFriendByUidAndFriendId(String uid, String friendId);
    
    int getFriendsCount(String uid);
    
    ResultResponse isFriend(String uid, String fid);
}
