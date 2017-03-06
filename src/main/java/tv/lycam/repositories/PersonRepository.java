package tv.lycam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tv.lycam.domain.Person;

/**
 * Created by jesse on 2017/3/5.
 */
public interface PersonRepository extends MongoRepository<Person,String> {
}
