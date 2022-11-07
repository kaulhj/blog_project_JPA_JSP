package com.example.blog.repository;

import com.example.blog.model.Board;
import com.example.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//빈으로 등록이 되나요? 자동으로 bean으로 등록이 된다. 어노테이션 생략 가능

public interface BoardRepository extends JpaRepository<Board, Integer> { //pk는 정수




    
}
