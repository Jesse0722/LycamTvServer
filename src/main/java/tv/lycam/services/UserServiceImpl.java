package tv.lycam.services;

import lycamPlusSdk.lycam.model.LycamplusUser;
import lycamPlusSdk.lycam.model.LycamplusUserResponse;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tv.lycam.common.BaseService;
import tv.lycam.domain.ResultResponse;

import tv.lycam.domain.User;
import tv.lycam.repositories.UserRepository;

import java.util.List;


/**
 * Created by jesse on 2017/3/3.
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    private static Logger logger= Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "userCache",keyGenerator = "keyGenerator")
    @Override
    public User getUserById(String id) {
        logger.info("这里读取了数据库~");
        return userRepository.findOne(id);
    }

//    @Cacheable(value = "userCache",keyGenerator = "keyGenerator")
    @Override
    public User login(String username, String password) {

        client.login(username,password);


        User user = userRepository.findByUserName(username);
        if(user!=null){
            String uid = user.getId();
            String token = getTokenByUserId(uid);
            user.setToken(token);
        }
        return user;
    }

    @Override
    public boolean logout() {
        return false;
        //return client.logout();
    }

    @Override
    public LycamplusUserResponse createUser() {

        return client.createUser();
    }

    @Override
    public LycamplusUserResponse createUser(LycamplusUser user) {
        LycamplusUserResponse response =client.createUser(user);
        System.out.println(response.isSuccess());
        String _id=response.getUuid();
        User newUser=null;
        if(response.isSuccess()){
            newUser=new User(_id,user.getUsername(),user.getPassword());
            AddUser(newUser);
            //创建用户成功，保存在appServer数据库
        }

        return response;
    }

    @Override
    public LycamplusUser getCurrentUser() {
        return client.getCurrentUser();
    }

    @Override
    public LycamplusUser updateCurrentUser(LycamplusUser user) {

        return client.updateCurrentUser(user);
    }

    @Override
    public ResultResponse resetPassWord(String uid, String oldPassword, String newPassword) {
        User user=getUserById(uid);

        if(user!=null&&user.getPassword()==oldPassword) {
            user.setPassword(newPassword);
            updateUser(user);
            //String token=getTokenByUserId(uid);
            return new ResultResponse(true);

        }
        return new ResultResponse();
    }

    @Override
    public String getTokenByUserId(String uid) {
        //return null;
        return masterClient.getUserTokenById(uid).getAccess_token();
    }

    @Override
    public LycamplusUser findUserById(String uuid) {

        return client.findUserById(uuid);
    }

    @Override
    public ObjectListing<LycamplusUser> listUsers() {

        return client.listUsers();
    }

    @Override
    public User AddUser(User user) { return  userRepository.insert(user);}

    @Override
    public void deleteUser(String id) { userRepository.delete(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> updateUserList(List<User> users) {
        return userRepository.save(users);
    }

    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @Override
    public List<User> getTopUsersByPopularity() {
        //按人气排名
        return userRepository.findAll(new Sort(Sort.Direction.DESC, "popularity"));
    }
}
