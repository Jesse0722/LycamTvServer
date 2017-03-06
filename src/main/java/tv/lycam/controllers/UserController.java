package tv.lycam.controllers;


import lycamPlusSdk.lycam.model.LycamplusUser;
import lycamPlusSdk.lycam.model.LycamplusUserResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import tv.lycam.domain.ResultResponse;
import tv.lycam.domain.User;
import tv.lycam.services.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private static Logger logger= Logger.getLogger(UserController.class);
	/*
	 * 用户登录，要求输入用户名和密码
	 */

    @RequestMapping(value="/")
    public String greeting(){
        System.out.println("username:");
        return "欢迎使用铼看直播...请先登录";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public User login(@RequestParam(value = "username")String username,
                      @RequestParam(value = "password" )String password){
        return userService.login(username, password);

    }

    @RequestMapping(value="/users/account/logout")
    public boolean logout(){
        return userService.logout();
    }
    /***
     * 注册用户
     */
    @RequestMapping(value="/users",method=RequestMethod.POST)
    public LycamplusUserResponse createUser(LycamplusUser user){
        return  userService.createUser(user);
    }

    //需要先进行登录
    @RequestMapping(value="/account",method=RequestMethod.GET)
    public LycamplusUser getCurrentUser(){
        return userService.getCurrentUser();
    }

    /***
     * 获取用户信息
     * @param objectId
     * @return
     */
    @RequestMapping(value="/users/{objectId}",method=RequestMethod.GET)
    public User getUser(@PathVariable String objectId){
        return userService.getUserById(objectId);
    }


    /***
     * 更新用户信息
     * @param objectId
     * @return
     */
    @RequestMapping(value="/users/{objectId}",method=RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable String objectId,@RequestBody User user){
        return userService.updateUser(user);
    }

    /*
     * 修改密码
     */
    @RequestMapping(value="/users/{objectId}/updatePassword", method=RequestMethod.PUT)
    public ResultResponse resetPassword(@PathVariable String objectId, @RequestParam("oldPassword")
            String oldPassword, @RequestParam("newPassword")  String newPassword){

        return userService.resetPassWord(objectId,oldPassword, newPassword);//更新lycam服务器用户密码
    }

    @RequestMapping(value="/users/{objectId}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable String objectId){
        System.out.println(objectId);
        userService.deleteUser(objectId);

    }

    @RequestMapping(value="/users",method=RequestMethod.GET)
    public Page<User> getUsersByPage(@PageableDefault(value = 10, sort = { "id" }, direction =Direction.DESC)
                                             Pageable pageable){

        return userService.getAll(pageable);
    }

    @RequestMapping(value="/users/token/{uid}",method = RequestMethod.GET)
    public String getUserTokenById(@PathVariable String uid){
        return userService.getTokenByUserId(uid);
    }

    @RequestMapping(value="/users/top",method=RequestMethod.GET)
    public @ResponseBody List<User> getTopUsersByPopularity(){
        return userService.getTopUsersByPopularity();
    }
}
