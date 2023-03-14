package com.spring.myspringsecurity.service;

import com.spring.myspringsecurity.model.Role;
import com.spring.myspringsecurity.model.User;
import com.spring.myspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User save(User user){

        //비밀번호 암호화해서 저장 + enabled 지정 + 권한 설정
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);

        return userRepository.save(user);
    }

}
