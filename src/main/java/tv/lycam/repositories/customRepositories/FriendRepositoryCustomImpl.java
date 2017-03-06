package tv.lycam.repositories.customRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import tv.lycam.domain.Follower;
import tv.lycam.domain.Friend;

import java.util.List;

/**
 * Created by jesse on 2017/3/4.
 */
public class FriendRepositoryCustomImpl implements FriendRepositoryCustom {
    @Autowired
    private MongoTemplate friendTemplate;

    //@Transactional
    @Override
    public Friend findByUidAndFriendId(String uid, String fid) {


        Criteria criteria=Criteria.where("uid").is(uid).and("friendId").is(fid);
        //   friendTemplate.findAll(Friend.class);
        List<Friend> friends=friendTemplate.find(Query.query(criteria), Friend.class);

        if(friends==null||friends.size()==0){
            System.out.println("friends为空");
            return null;
        }

        return  friends.get(0);//哪里有问题？
    }
}
