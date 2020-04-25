package com.litao.springclouddemo.feign;

import com.litao.springclouddemo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignCallback  implements  UserFeignClient{
    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("固定值");
        return user;
    }

    @Override
    public User getUserByUser(User user) {

        user.setUsername("固定值");
        return user;
    }

    @Override
    public String getUsernameById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("固定值");
        return user.getUsername();
    }
}
