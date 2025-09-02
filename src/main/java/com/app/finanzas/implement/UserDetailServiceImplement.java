package com.app.finanzas.implement;

import com.app.finanzas.entity.User;
import com.app.finanzas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImplement implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userLocal = userRepository.findByemail(email);

        return org.springframework.security.core.userdetails.User.builder()
                .username(userLocal.getEmail())
                .password(userLocal.getPassword())
                .authorities(String.valueOf(userLocal.getRole()))
                .build();
    }
}
