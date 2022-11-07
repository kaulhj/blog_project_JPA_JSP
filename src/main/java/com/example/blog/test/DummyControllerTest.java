package com.example.blog.test;

import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;


/** CRUD 테스트 클래스 **/

@RestController
public class DummyControllerTest {
    
    @Autowired //메모리에 뜰때 메모리에 띄우기 의존성 주입, DI
    private UserRepository userRepository;
    
    @PostMapping("/dummy/join")
    public String join(User user){ //key=value, 약속된 규칙
        System.out.println(user.getUsername()+' '+user.getPassword()+' '+user.getEmail());
        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }


//    @PostMapping("/dummy/signUser")
//    public String detail(
//            @RequestParam String username,
//            @RequestParam String password){
//        //user의 4번을 찾으면 db에서 못찾으면 user가 null이 되니까 null이 리턴이 되니까 프로그램에 문제가 있음. 옵셔널로 유저객체를 감싸서
//        //가져올테니 null인지 아닌지 판단해서 return하라.
//        User user = userRepository.findByUsername(username).orElseThrow(()-> {
//            return new IllegalArgumentException("해당 유저는 없습니다.");
//        });
//
//        if(!user.getPassword().equals(password))
//            return "비밀번호가 틀렸습니다.";
//        //user객체는 자바 오브젝트
//        //스프링부트는 messageConverter라는 것이 응답시에 자동 작동
//        //만약 자바 오브젝트를 리턴하게 되면 messageConverter가 jackson 라이브러리를 호출해서 user 오브젝트를 json으로 변환해서 브라우저에게 던져준다.
//        return "로그인 성공";
//    }

    @GetMapping("/dummy/users")
    public List<User>list(){
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user" )
    public List<User> pageList(@PageableDefault(size = 3, sort = "id",direction = Sort.Direction.DESC)Pageable pageable){

        Page<User>pagingUser = userRepository.findAll(pageable);
        List<User> users =   userRepository.findAll(pageable).getContent();

        return users;
    }

    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody  User requestUser){ //json 데이터를 요청해서 스프링이 자바 객체로 변환해서 받아줌
                System.out.println("apssword: "+requestUser.getPassword());
                System.out.println("email: "+requestUser.getEmail());

                User user = userRepository.findById(id).orElseThrow(()->{
                    return new IllegalArgumentException("수정 실패");
                        });

                user.setPassword(requestUser.getPassword());
                user.setEmail(requestUser.getEmail());

                //id값이 있는 save를 하면 업데이트를 실행해줌,  다른값들은 null로 변함, 그래서 save를 잘 안씀
                //userRepository.save(user);


                //더티체킹, save하지 않아도 업데이트가 된다.
                return user;
    }

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "해당 아이디는 없습니다.";
        }


        return "삭제됨";
    }

    
}
