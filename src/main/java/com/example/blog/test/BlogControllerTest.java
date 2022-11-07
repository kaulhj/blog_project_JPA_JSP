package com.example.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController  //스캔해서 모든 파일 메모리 new하는 것이 아니라 특정 어노테이션이 붙어있는 클래스 파일들을 new(ioc)해서 스프링 컨테이너에 관리
public class BlogControllerTest {

    @GetMapping("/test/hello")
    public String hello(){
        return "<h1>hello spring boot<h1>";
    }



}
