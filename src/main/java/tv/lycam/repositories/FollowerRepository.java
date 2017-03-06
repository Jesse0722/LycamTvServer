package tv.lycam.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import tv.lycam.domain.Follower;
import tv.lycam.repositories.customRepositories.FollowerRepositoryCustom;

import java.util.List;

/**
 * Created by lycam on 16/4/29.
 */
public interface FollowerRepository extends MongoRepository<Follower,String>,FollowerRepositoryCustom {
    List<Follower> findByUid(String id);

}
