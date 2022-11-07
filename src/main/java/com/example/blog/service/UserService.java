package com.example.blog.service;

import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;



    @Transactional
    public void 회원가입(User user){
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setRole(RoleType.USER);
        user.setPassword(encPassword);
            userRepository.save(user);

    }

    @Transactional
    public  void  회원수정(User user){
        //수정시에는 영속성 컨텍스트 user 영속화를 시키고, 영속화된 유저 오브젝트를 수정
        
        User persistance = userRepository.findById(user.getId()).orElseThrow(()-> {
            return new IllegalArgumentException("회원 찾기 실패");
        });

        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        persistance.setPassword(encPassword);
        persistance.setEmail(user.getEmail());



        //회원수정 함수 종료 시
    }


}
