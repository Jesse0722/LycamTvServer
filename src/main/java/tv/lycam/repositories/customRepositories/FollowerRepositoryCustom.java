package tv.lycam.repositories.customRepositories;

import tv.lycam.domain.Follower;

/**
 * Created by jesse on 2017/3/4.
 */
public interface FollowerRepositoryCustom {
    Follower findByUidAndFollowerId(String uid, String followerId);
}
