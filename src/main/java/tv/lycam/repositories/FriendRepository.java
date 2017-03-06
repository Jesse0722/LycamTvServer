package tv.lycam.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tv.lycam.domain.Friend;
import tv.lycam.repositories.customRepositories.FriendRepositoryCustom;

import java.util.List;

/**
 * Created by lycam on 16/4/29.
 */
public interface FriendRepository extends MongoRepository<Friend,String>,FriendRepositoryCustom{
   
	List<Friend> findByUid(String uid);
   
}
