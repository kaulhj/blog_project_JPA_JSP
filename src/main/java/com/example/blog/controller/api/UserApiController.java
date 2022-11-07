package com.example.blog.controller.api;


import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.config.auth.PrincipalDetailService;
import com.example.blog.controller.dto.ResponseDto;
import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PrincipalDetailService principalDetailService;


//    @Autowired
//    private HttpSession session;



        @PostMapping("/auth/joinProc")
        public ResponseDto<Integer> save(@RequestBody User user){

            userService.회원가입(user);
            return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
        }


        @PutMapping("/user")
        public ResponseDto<Integer> update(@RequestBody User user){ //json을 위해 requestbody, 없으면 x-www-erer
            userService.회원수정(user);


            UserDetails userDetails = principalDetailService.loadUserByUsername(user.getUsername());

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);


            return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

        }





//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user){
//            System.out.println("로그인호출됨");
//            User principal = userService.로그인(user); //principal 접근주체
//
//        if(principal !=null){
//            session.setAttribute("principal",principal);
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//    }

}