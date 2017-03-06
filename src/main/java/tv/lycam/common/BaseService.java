package tv.lycam.common;


import lycamPlusSdk.lycam.LycamplusClient;
import lycamPlusSdk.lycam.model.TokenAssumeResponse;

/**
 * Created by jesse on 2017/3/3.
 */
public class BaseService {
    private static final String APP_KEY="BWT8UYQBY1";
    private static final String APP_SECRET="znqPiWzGNz6pPePWTUYDDX1ToHg68I";
    private static final String MASTER_SECRET="Qb6LrCX5KskAPhpnXIPl47f26eCHkO";

    protected static LycamplusClient masterClient;
    protected static LycamplusClient client;

    public BaseService(){
        masterClient=new LycamplusClient(APP_KEY, APP_SECRET);
        //client.login("james","lijiajun123");
        masterClient.login("master",MASTER_SECRET);
        client=new LycamplusClient(APP_KEY,APP_SECRET);
    }


}