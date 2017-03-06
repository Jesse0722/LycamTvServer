package tv.lycam.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tv.lycam.domain.Follower;
import tv.lycam.domain.User;
import tv.lycam.repositories.FollowerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lycam on 16/4/29.
 */
@Service
public class FollowerServiceImpl implements FollowerService{

    @Autowired
    private FollowerRepository repository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<String> getFollowerIds(String uid) {
    	List<Follower> followers;
        List<String> followersId=new ArrayList<String>();
    	followers=repository.findByUid(uid);
        for(Follower follower:followers){
        	if(follower!=null){
        		followersId.add(follower.getFollowerId());
        	}
        }
        return followersId;
    }

    @Override
    public List<User> getFollowers(String uid) {
        List<String> followerIds=getFollowerIds(uid);
        List<User> followers=new ArrayList<User>();
        for(int i=0;i<followerIds.size();i++){
            User follower=userService.getUserById(followerIds.get(i));
            if(follower!=null) {
                followers.add(follower);
            }
        }
        return followers;
    }

    @Override
    public Follower addFollower(Follower follower) {
        return  repository.save(follower);
    }

    @Override
    public void subFollower(Follower follower) {
     //   List<Follower> followers;
       // followers=repository.findByUidAndFollowerId(uid,fid);
        repository.delete(follower);
       // repository.delete(followers.get(0));
    }

	@Override
	public Follower getFollowerByUidAndFollowerId(String uid, String followerId) {
		// TODO Auto-generated method stub
		return repository.findByUidAndFollowerId(uid, followerId);
	}

	@Override
	public int getFollowersCount(String uid) {
		// TODO Auto-generated method stub
		return getFollowers(uid).size();
	}
    
    
}
