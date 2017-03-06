package tv.lycam.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.lycam.domain.Follower;
import tv.lycam.domain.Friend;
import tv.lycam.domain.ResultResponse;
import tv.lycam.domain.User;
import tv.lycam.repositories.FriendRepository;

/**
 * Created by lycam on 16/4/29.
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository repository;

    @Autowired
    private  UserService userService;

    @Autowired
    private FollowerServiceImpl followerService;

    @Override
    public List<String> getFriendsIds(String uid) {
    	List<Friend> friends;
        List<String> friendsId=new ArrayList<String>();
        friends=repository.findByUid(uid);
        for(Friend friend:friends){
        	if(friend!=null){
        		friendsId.add(friend.getFriendId());
        	}
        }
        return friendsId;
    }
    

    @Override
    public List<User> getFriends(String uid) {
        List<String> friendsIds=getFriendsIds(uid);
        List<User> friends=new ArrayList<User>();
        for(int i=0;i<friendsIds.size();i++){
            User friend=userService.getUserById(friendsIds.get(i));
            if(friend!=null) {
                friends.add(friend);
            }
        }
        return friends;
    }
    
    /*
     * 增加关注
     * 
     */
    @Transactional
    @Override
    public ResultResponse addFriend(String uid, String fid) {
   
    	Friend friend =null; 
    	if(getFriendByUidAndFriendId(uid, fid)!=null){
    		System.out.println("AddFriend:You have this friend already!");
    		return new ResultResponse(false);
    	}
    	
    	friend = new Friend(uid,fid);
        Follower follower=new Follower(fid,uid);//关注者成为粉丝
        
        List<User> userList=new ArrayList<User>();
        try {     	
            repository.save(friend);//我关注你   
            followerService.addFollower(follower);//对你来说我就是你的粉丝
            
        	User user=userService.getUserById(uid);//更新数量
        	user.setFriendsCount(user.getFriendsCount()+1);
        	
        	User friendUser=userService.getUserById(fid);
        	friendUser.setFollowersCount(friendUser.getFollowersCount()+1);
        	
        	userList.add(user);
        	userList.add(friendUser);
        	userService.updateUserList(userList);
   
        }catch (Exception e){
          
            return new ResultResponse(false);
        }
        return new ResultResponse(true);
    }

    /**
     * 取消关注
     */
    @Transactional
    @Override
    public ResultResponse subFriend(String uid, String fid) {

    	Friend friend=null;
    	if(getFriendByUidAndFriendId(uid, fid)==null){
    		System.out.println("subFriend:You have No this friend!");
    		return new ResultResponse(false);
    	}
    	List<User> userList=new ArrayList<User>();
        try {
            friend = getFriendByUidAndFriendId(uid, fid); 
            repository.delete(friend);//我取消你的关注
            Follower follower=followerService.getFollowerByUidAndFollowerId(fid, uid);
            followerService.subFollower(follower);//对你来说你就少了我这个粉丝
            
        	User user=userService.getUserById(uid);//更新关注数量
        	user.setFriendsCount(user.getFriendsCount()-1);
        	
        	User friendUser=userService.getUserById(fid);
        	friendUser.setFollowersCount(friendUser.getFollowersCount()-1);
        	
        	userList.add(user);
        	userList.add(friendUser);
        	userService.updateUserList(userList);
            
        }catch(Exception e ){
        	
             return new ResultResponse(false);
        }
        return  new ResultResponse(true);
    }

    /*
     *根据两个id查找关注记录
     * 
     */
	@Override
	public Friend getFriendByUidAndFriendId(String uid, String friendId) {
		// TODO Auto-generated method stub
		return repository.findByUidAndFriendId(uid, friendId);//出问题,已解决
	}


	@Override
	public int getFriendsCount(String uid) {
		// TODO Auto-generated method stub
		return getFriends(uid).size();
	}


	@Override
	public ResultResponse isFriend(String uid, String fid) {
		// TODO Auto-generated method stub
		Friend friend = repository.findByUidAndFriendId(uid, fid);
		if(friend==null){
			return new ResultResponse(false);
		}
		
		return new ResultResponse(true);
	}
}
