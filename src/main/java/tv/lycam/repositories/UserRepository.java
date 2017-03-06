package tv.lycam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tv.lycam.domain.User;

/**
 * Created by jesse on 2017/3/3.
 */
public interface UserRepository extends MongoRepository<User,String>{

    User findByUserName(String userName);//注意命名规则，对象属性为userName,


}
