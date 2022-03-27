package com.team12.foodforall.service.user;

import com.team12.foodforall.domain.LoginUser;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author: Heng Gao
 * @date: 27/03/2022 03:05
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(Objects.isNull(user)){
            throw new RuntimeException("Invalida username or password");
        }

        //TODO check roles:从数据库中查询权限信息，并假如到LoginUser中去

        return new LoginUser(user);
    }
}
