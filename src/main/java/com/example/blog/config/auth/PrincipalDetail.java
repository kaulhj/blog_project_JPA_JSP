package com.example.blog.config.auth;

import com.example.blog.model.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;



@Data
public class PrincipalDetail implements UserDetails {
    private User user;  //컴포지션 extends하는건 상속

    public PrincipalDetail(User user){
        this.user = user;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { //false면 계정이 만료된것
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //false면 계정이 잠긴것
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비번이 만료되지않았는지
        return true;
    }

    @Override
    public boolean isEnabled() { //계정이 활성화가 되어있는지
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //계정이 어떤권한을 가졌는지

        Collection<GrantedAuthority> collectors = new ArrayList<>();


        collectors.add(() -> {
            return "ROLE_" + user.getRole();
        });
        return collectors;

    }
}
