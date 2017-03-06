package tv.lycam.repositories.customRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import tv.lycam.domain.Follower;

import java.util.List;

/**
 * Created by jesse on 2017/3/4.
 */
public class FollowerRepositoryCustomImpl implements FollowerRepositoryCustom{

        @Autowired
        private MongoTemplate template;

	/*
	 * 此方法正确
	 */
        @Override
        public Follower findByUidAndFollowerId(String uid, String followerId) {
            // TODO Auto-generated method stub

            Criteria criteria=Criteria.where("uid").is(uid).and("followerId").is(followerId);

            List<Follower> followers=template.find(Query.query(criteria), Follower.class);

            if(followers==null||followers.size()==0){
                System.out.println("friends为空");
                return null;
            }
            return followers.get(0);

        }

}
