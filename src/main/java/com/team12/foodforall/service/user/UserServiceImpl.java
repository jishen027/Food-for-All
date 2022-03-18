package com.team12.foodforall.service.user;

import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author: Heng Gao
 * @date: 18/03/2022 :19:25
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteUserById(long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

    @Override
    public User addUser(@Valid User user){
        return userRepository.save(user);
    }

    @Override
    public Optional<@Valid User> findUserById(Long id) { return userRepository.findById(id);}

    @Override
    public ArrayList<User> findAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

}
