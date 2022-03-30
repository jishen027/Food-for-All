package com.team12.foodforall.service.user;

import com.team12.foodforall.domain.LoginForm;
import com.team12.foodforall.domain.RegisterForm;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User registerUser(RegisterForm registerForm){

        // Duplicate Account Validation
        User queryResult = userRepository.findByEmail(registerForm.getEmail());
        if(queryResult != null){
            //TODO: replace exception
            System.err.println("account already exists");
            throw new RuntimeException();
        }
        // TODO: more validation


        //TODO: Encrypt Password
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setFirstName(registerForm.getFirstName());
        user.setLastName(registerForm.getLastName());
        user.setPassword(registerForm.getPassword());
        user.setCharityName(registerForm.getCharityName());
        return userRepository.save(user);
    }


    //   TODO:v01- login by email
    @Override
    public User login(LoginForm loginForm) {
        // check email format
        // already done in controller

        // check email exist
        User exist = userRepository.findByEmail(loginForm.getEmail());

        System.out.println(loginForm.getEmail());
        System.out.println(loginForm.getPassword());
        if(exist.getPassword().equals(loginForm.getPassword())){
            return exist;
        } else {
            return null;
        }


    }

    @Override
    public Optional<User> findUserById(Long id) { return userRepository.findById(id);}

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public ArrayList<User> findAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }
}
