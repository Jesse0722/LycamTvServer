package tv.lycam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tv.lycam.batch.ScheduledTaskService;
import tv.lycam.domain.BatchRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jesse on 2017/3/5.
 */
@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @Override
    public BatchRecord batchExecute(String fileName, String userName){
        try {
            scheduledTaskService.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BatchRecord(userName,new Date(),fileName,true);

    }

    @Override
    public List<String> getBatchTasks() {
        String[] strNames= new String[]{"custom1.csv","custom2.csv","custom3.csv"};
        List<String> fileNames = new ArrayList<String>();
        for(String name:strNames){
            fileNames.add(name);
        }
        return fileNames;
    }
}
