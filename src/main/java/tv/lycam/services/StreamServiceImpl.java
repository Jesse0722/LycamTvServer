package tv.lycam.services;

import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tv.lycam.common.BaseService;
import tv.lycam.configs.AppConfig;
import tv.lycam.domain.StreamExtraInfo;
import tv.lycam.domain.User;
import tv.lycam.repositories.UserRepository;

/**
 * Created by jesse on 2017/3/4.
 */
@Service
public class StreamServiceImpl extends BaseService implements StreamService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MessageServiceImpl messageService;

    @Override
    public LycamplusStream createStream(LycamplusStream stream) {
        String uid=null;
        if(stream != null){
            uid = stream.getUser();//user即uid
        }
        LycamplusStream streamResponse=masterClient.createStream(stream);

        streamResponse.setThumbnailUrl(getStreamThumbnail(uid));

        System.out.print("StreamThumbnail:"+getStreamThumbnail(uid));

        return streamResponse;
    }

    @Override
    public LycamplusStream findStreamById(String streamId) {
        return client.findStreamById(streamId);
    }

    /***
     * 获取直播视频列表，并为每个视频设置信息
     * @return
     */
    @Override
    public ObjectListing<LycamplusStream> listStreams() {

        ObjectListing<LycamplusStream> streamList=masterClient.sinceQuery();

        for(int i=0;i<streamList.getItems().size();i++){
            String userId=  streamList.getItems().get(i).getUser();
            String streamId=streamList.getItems().get(i).getStreamId();
            User user=userService.getUserById(userId);
            if(user!=null){
                StreamExtraInfo extraInfo=new StreamExtraInfo();
                extraInfo.setAvatarUrl(user.getAvatarUrl());
                extraInfo.setUserName(user.getUserName());
                extraInfo.setOnlineCount(messageService.getUsersByTopic(streamId).size());//通过消息通道获取在线人数
                extraInfo.setPopularity(user.getPopularity());

                streamList.getItems().get(i).setExtraInfo(extraInfo);
                streamList.getItems().get(i).setThumbnailUrl(user.getAvatarUrl());
            }
        }
        return streamList;
    }

    @Override
    public LycamplusStream updateStream(LycamplusStream stream) {
        return client.updateStream(stream);
    }

    @Override
    public boolean destroyStream(String streamId) {
        return client.destroyStream(streamId);
    }

    @Override
    public LycamplusStream createOrUpdateStream(LycamplusStream stream) {
        return client.createOrUpdateStream(stream);
    }

    /***
     * 获取直播视频封面
     * @param uid
     * @return
     */
    public String getStreamThumbnail(String uid){

        User user = userRepository.findOne(uid);

        if(user!=null) {
            String thumbnailUrl=user.getStreamImageUrl();
            String avatarUrl=user.getAvatarUrl();

            if (thumbnailUrl != null&&!thumbnailUrl.equals("")) {
                return thumbnailUrl;
                //	stream.setThumbnailUrl(thumbnailUrl);
            }
            else if(avatarUrl!=null&&!avatarUrl.equals("")){
                return avatarUrl;
                //stream.setThumbnailUrl(avatarUrl);
            }
            else{
                return AppConfig.DEFAULT_STREAM_IMAGE_URL;//默认封面
                //stream.setThumbnailUrl(AppConfig.DEFAULT_STREAM_IMAGE_URL);
            }
        }
        return null;
    }
}
