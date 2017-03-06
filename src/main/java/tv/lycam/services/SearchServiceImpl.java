package tv.lycam.services;

import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tv.lycam.common.BaseService;
import tv.lycam.domain.*;

/**
 * Created by lycam on 16/4/27.
 */
@Service
public class SearchServiceImpl extends BaseService implements SearchService{

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private MessageServiceImpl messageService;
	

    @Override
    public SearchStreamsResponse searchStreams(SearchStreamsRequest searchStreamsRequest) {

        return null;
    }

    @Override
    public SearchStreamsResponse searchUsers(SearchUsersRequest searchUsersRequest) {
        return  null;
    }

    @Override
    public SearchLocationResponse searchLoction(SearchLoctionRequest searchLoctionRequest) {
        return null;
    }

	@Override
	public ObjectListing<LycamplusStream> sinceQuery() {
		// TODO Auto-generated method stub
		ObjectListing<LycamplusStream> streamList=masterClient.sinceQuery();
		// for(int i=0;i<streamList.getItems().size();i++){
		// 	StreamUserBody streamuser=  streamList.getItems().get(i).getUser();
		// 	String userId=streamuser.getUuid();
		// 	String streamId=streamList.getItems().get(i).getStreamId();
		// 	User user=userService.getUserById(userId);
					
		// 	StreamExtraInfo extraInfo=new StreamExtraInfo();
		// 	if(user!=null){
		// 		extraInfo.setAvatarUrl(user.getAvatarUrl());
		// 		extraInfo.setUserName(user.getUserName());
		// 		extraInfo.setOnlineCount(messageService.getUsersByTopic(streamId).size());
			
		// 		streamList.getItems().get(i).setExtraInfo(extraInfo);
		// 		streamList.getItems().get(i).setThumbnailUrl(user.getAvatarUrl());
		// 	}
		// }
		
		return streamList;
	}
	
	
	
}
