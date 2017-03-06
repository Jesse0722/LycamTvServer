package tv.lycam.services;

import lycamPlusSdk.lycam.model.LycamplusUser;
import lycamPlusSdk.lycam.model.LycamplusUserResponse;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tv.lycam.domain.ResultResponse;
import tv.lycam.domain.User;

import java.util.List;

/**
 * Created by jesse on 2017/3/3.
 */
public interface UserService {


    /**
     * appServer相关处理
     */
    User AddUser(User user);

    void deleteUser(String id);

    User updateUser(User user);

    List<User> updateUserList(List<User> users);

    User getUserById(String id);

    User getUserByName(String userName);

    List<User> getAllUsers();

    Page<User> getAll(Pageable pageable);

    List<User> getTopUsersByPopularity();

    User login(String username, String password);

    boolean logout();

    LycamplusUserResponse createUser();

    LycamplusUserResponse createUser(LycamplusUser user);

    LycamplusUser getCurrentUser();

    LycamplusUser findUserById(String uuid);

    LycamplusUser updateCurrentUser(LycamplusUser user);

    ObjectListing<LycamplusUser> listUsers();

    ResultResponse resetPassWord(String uid, String oldPassword, String newPassword);

    String getTokenByUserId(String uid);
}
