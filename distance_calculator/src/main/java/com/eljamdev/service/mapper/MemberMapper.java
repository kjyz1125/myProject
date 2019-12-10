package com.eljamdev.service.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.eljamdev.vo.User;

@Service
public interface MemberMapper {
	public ArrayList<HashMap<String, Object>> getMemberInfo(String id);
	public User getMember(String id);
}
