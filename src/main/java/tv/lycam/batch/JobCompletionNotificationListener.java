package tv.lycam.batch;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tv.lycam.domain.Person;
import tv.lycam.repositories.PersonRepository;

import java.util.List;

/**
 * Created by jesse on 2017/3/5.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

//    private  final MongoOperations mongoOps ;

    /**
     * job完成时响应，初始化jdbc
     * @param
     */
    public JobCompletionNotificationListener() {

//        mongoOps= new MongoTemplate(new MongoClient(),"test");
    }
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus()== BatchStatus.COMPLETED){
            log.info("!!!任务完成！开始验证结果...");
            List<Person> results = personRepository.findAll();

            for(Person person:results){
                log.info("Found<"+person+">in mongodb!");
            }
        }
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        super.beforeJob(jobExecution);
    }
}
