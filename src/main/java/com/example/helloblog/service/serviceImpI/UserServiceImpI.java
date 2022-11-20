package com.example.helloblog.service.serviceImpI;

import com.example.helloblog.domain.User;
import com.example.helloblog.repository.UserDao;
import com.example.helloblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpI implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User loginService(String uname, String password) {
        User user = userDao.findByUnameAndPassword(uname, password);
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(String uname, String password) {
        User user = new User();
        user.setUname(uname);
        user.setPassword(password);
        if(userDao.findByUname(user.getUname())!=null){
            // 无法注册
            return null;
        }else{

            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
