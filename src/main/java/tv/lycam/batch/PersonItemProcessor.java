package tv.lycam.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import tv.lycam.domain.Person;

/**
 * Created by jesse on 2017/3/5.
 */
public class PersonItemProcessor implements ItemProcessor<Person,Person>{

    private static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);


        logger.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
