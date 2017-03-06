package tv.lycam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tv.lycam.domain.Gift;


public interface GiftRepository extends MongoRepository<Gift, String>{
	
}
