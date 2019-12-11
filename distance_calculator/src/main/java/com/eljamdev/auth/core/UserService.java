package com.eljamdev.auth.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eljamdev.service.MemberService;
import com.eljamdev.vo.User;

@Component
public class UserService implements UserDetailsService{

	@Autowired
	private MemberService memberService;

	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{

        System.out.println(id);

        User userInfo = new User();

        userInfo = memberService.getMember(id);

        User user = new User();

        user.setName(userInfo.getUsername());
        user.setPassword(userInfo.getPassword());
        user.setName(userInfo.getName());
        user.setMemSq(userInfo.getMemSq());
        user.setRole(userInfo.getRole());
        
        return user;
    }
}
