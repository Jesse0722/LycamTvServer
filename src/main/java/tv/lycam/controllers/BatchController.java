package tv.lycam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tv.lycam.domain.BatchRecord;
import tv.lycam.services.BatchServiceImpl;

import java.util.List;

/**
 * Created by jesse on 2017/3/5.
 */
@RestController
public class BatchController {
    @Autowired
    private BatchServiceImpl batchService;

    @RequestMapping(value = "/batchTasks",method = RequestMethod.GET)
    public List<String> getBatchTasks() {
        return batchService.getBatchTasks();
    }

    @RequestMapping(value = "/batchTasks",method = RequestMethod.POST)
    public BatchRecord executeBatchTask(String fileName, String userName) {
        return batchService.batchExecute(fileName,userName);
    }
}
