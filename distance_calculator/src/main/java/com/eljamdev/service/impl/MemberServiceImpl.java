package com.eljamdev.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eljamdev.auth.core.PasswordEncoding;
import com.eljamdev.service.MemberService;
import com.eljamdev.service.mapper.MemberMapper;
import com.eljamdev.vo.User;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<HashMap<String, Object>> getMemberInfo(String id) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();		
		
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		list.addAll(memberMapper.getMemberInfo(id));
		
		return list;
	}

	@Override
	public User getMember(String id) {
		
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

		return 	memberMapper.getMember(id);
	}

	@Override
	public int insertMember(HashMap<String, Object> map) {
		
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int result = 0;
		
		PasswordEncoding encoder = new PasswordEncoding();
	
		String decodedPassword = (String) map.get("password");
		
		String encodedPassword = encoder.encode(decodedPassword);
		
		map.put("password", encodedPassword);
	
		result = memberMapper.insertMember(map);
		
		return result;
	}	

}
