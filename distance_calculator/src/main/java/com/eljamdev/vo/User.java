package com.eljamdev.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String memSq;
	private String name;
	private String phone;
	private String reg_date;
	private String password;
	private String useyn;
	private String role;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        String str= getRole();        // Role이 ADMIN일 경우 ROLE_ADMIN 권한 부여 
       
       if(str!=""&&str!=null){
    	   if(str.equals("ROLE_ADMIN")){
        	   authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
           }else {
        	   authorities.add(new SimpleGrantedAuthority("ROLE_USER")); 
           }
       }else{
    	   authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // 아닐경우 일반유저 권한 부여
       }
        
        return authorities;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
