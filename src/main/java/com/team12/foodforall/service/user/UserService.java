package com.team12.foodforall.service.user;

import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Heng Gao
 * @date: 17/03/2022 :22:25
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
