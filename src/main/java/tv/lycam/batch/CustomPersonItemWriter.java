package tv.lycam.batch;

import org.springframework.batch.item.ItemWriter;
import tv.lycam.domain.Person;
import tv.lycam.repositories.PersonRepository;

import java.util.List;

/**
 * Created by jesse on 2017/3/5.
 */
public class CustomPersonItemWriter implements ItemWriter<Person> {


    private PersonRepository personRepository;

    public CustomPersonItemWriter(PersonRepository personRepository){
        this.personRepository=personRepository;

    }

    @Override
    public void write(List<? extends Person> items) throws Exception {
        //插入数据库
        personRepository.insert(items);
    }
}
