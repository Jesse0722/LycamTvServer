package tv.lycam.services;

import tv.lycam.domain.BatchRecord;

import java.util.List;

/**
 * Created by jesse on 2017/3/5.
 */
public interface BatchService {
    BatchRecord batchExecute(String fileName, String userName);

    List<String> getBatchTasks();
}
