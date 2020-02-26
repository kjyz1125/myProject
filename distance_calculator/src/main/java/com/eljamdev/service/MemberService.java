package com.eljamdev.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.eljamdev.vo.User;

@Service
public interface MemberService {
	public ArrayList<HashMap<String,Object>> getMemberInfo(String id);
	public User getMember(String id);
	public int insertMember(HashMap<String, Object> map);
}
