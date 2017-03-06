package tv.lycam.domain;

import java.util.Date;

/**
 * Created by jesse on 2017/3/5.
 */
public class BatchRecord {
    private String userName;
    private Date datetime;
    private String fileName;
    private boolean isSuccess;

    public BatchRecord(String userName, Date datetime, String fileName,boolean isSuccess) {
        this.userName = userName;
        this.datetime = datetime;
        this.fileName = fileName;
        this.isSuccess = isSuccess;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
