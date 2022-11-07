package com.example.blog.repository;

import com.example.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//빈으로 등록이 되나요? 자동으로 bean으로 등록이 된다. 어노테이션 생략 가능

public interface UserRepository extends JpaRepository<User, Integer> { //pk는 정수


    Optional<User>findByUsername(String username);













    //Select * From User where username=? and password = ?, jpa네이밍 쿼리
//    User findByUsernameAndPassword(String username,String password);
    
//    동일하게 쿼리가능@Query(value ="Select * From User where username=?1 and password = ?2",nativeQuery = true )
    //User login(String username, String password);
    
}
