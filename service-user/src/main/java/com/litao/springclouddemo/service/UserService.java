package com.litao.springclouddemo.service;


import com.litao.springclouddemo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /**
     * 根据Id，查询user
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("张三");
        return  user;
    }

    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
    public String getUsernameById(Integer id){
        User user = getUserById(id);
        return user.getUsername();
    }
}
