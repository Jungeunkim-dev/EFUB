package com.security.testcode.config;

import com.security.testcode.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetail implements UserDetails {

    private String email;
    private String password;
    private String auth;

    public MyUserDetail (User user){
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.auth="ROLE_"+user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
        //이후에 리스트로 작성할 경우가 많기 때문에 리스트로 작성.
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        //해당계정만료?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //비밀번호 만료?
        return true;
    }

    @Override
    public boolean isEnabled() {
        //사용가능 계정?
        return true;
    }
}
