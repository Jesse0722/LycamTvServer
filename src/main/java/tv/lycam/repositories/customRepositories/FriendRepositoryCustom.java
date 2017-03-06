package tv.lycam.repositories.customRepositories;

import tv.lycam.domain.Friend;

/**
 * Created by jesse on 2017/3/4.
 */
public interface FriendRepositoryCustom {
    Friend findByUidAndFriendId(String uid, String fid);
}
