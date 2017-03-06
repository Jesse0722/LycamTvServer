package tv.lycam.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tv.lycam.domain.CountResponse;
import tv.lycam.domain.ResultResponse;
import tv.lycam.domain.User;
import tv.lycam.services.FollowerServiceImpl;
import tv.lycam.services.FriendServiceImpl;

import java.util.List;

/**
 * Created by lycam on 16/4/29.
 */

@Controller
public class FriendshipsController {

    @Autowired
    private FollowerServiceImpl followerService;

    @Autowired
    private FriendServiceImpl friendService;

    /*
     * 获取所有粉丝id
     */
    @RequestMapping(value="/friendships/followers/ids/{uid}",method = RequestMethod.GET)
    public @ResponseBody
    List<String> getFollowersIds(@PathVariable String uid){
        return followerService.getFollowerIds(uid);
    }
    
    /*
     * 获取所有粉丝信息列表
     */
    @RequestMapping(value="/friendships/followers/{uid}",method = RequestMethod.GET)
    public @ResponseBody
    List<User> getFollowers(@PathVariable String uid){
        return followerService.getFollowers(uid);
    }
    /*
     * 获取所有关注者Id
     */
    @RequestMapping(value="/friendships/friends/ids/{uid}",method = RequestMethod.GET)
    public @ResponseBody
    List<String> getFriendsIds(@PathVariable String uid){
        return friendService.getFriendsIds(uid);
    }
    
    /*
     * 获取关注者信息列表
     */
    @RequestMapping(value="/friendships/friends/{uid}",method = RequestMethod.GET)
    public @ResponseBody
    List<User> getFriends(@PathVariable String uid){
        return friendService.getFriends(uid);
    }
    /*
     *关注一个人
     */
    @RequestMapping(value="/friendships/friends",method = RequestMethod.POST)
    public @ResponseBody
    ResultResponse addFriends(@RequestParam("uid") String uid, @RequestParam("fid") String fid){
        return friendService.addFriend(uid,fid);
    }
    /*
     * 取消关注
     */
    @RequestMapping(value="/friendships/friends/delete",method = RequestMethod.POST)
    public @ResponseBody
    ResultResponse subFriends(@RequestParam("uid") String uid,@RequestParam("fid") String fid){
    	System.out.println(uid+"  "+fid);
        return friendService.subFriend(uid,fid);
    }
    
    /*
     * 获取关注好友数
     */
    @RequestMapping(value="/friendships/friends/count/{uid}", method=RequestMethod.GET)
    public @ResponseBody
    CountResponse getFriendsCount(@PathVariable("uid") String uid){
    	return new CountResponse(friendService.getFriendsCount(uid));
    }
    
    /*
     * 获取粉丝数
     */
    @RequestMapping(value="/friendships/followers/count/{uid}", method=RequestMethod.GET)
    public @ResponseBody
    CountResponse getFollowersCount(@PathVariable("uid") String uid){
    	return new CountResponse(followerService.getFollowersCount(uid));
    }
    /*
     * 获取两个用户是否关注
     */
    @RequestMapping(value="/friendships/{uid}&{fid}", method=RequestMethod.GET)
    public @ResponseBody
    ResultResponse isFriend(@PathVariable("uid") String uid,@PathVariable("fid") String fid){
    	return friendService.isFriend(uid, fid);
    }
}
