package com.example.blog.controller.api;


import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.controller.dto.ResponseDto;
import com.example.blog.model.Board;
import com.example.blog.model.User;
import com.example.blog.service.BoardService;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
public class BoardApiController {


@Autowired
private BoardService boardService;



        @PostMapping("/api/board")
        public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail){
            boardService.글쓰기(board, principalDetail.getUser());

            return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
        }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        boardService.글삭제하기(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }


    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
            boardService.글수정하기(id, board);
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