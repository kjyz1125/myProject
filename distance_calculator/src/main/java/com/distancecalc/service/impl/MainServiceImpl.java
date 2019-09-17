package com.distancecalc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distancecalc.service.*;
import com.distancecalc.service.mapper.MainMapper;

@Repository
public class MainServiceImpl implements MainService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<HashMap<String, Object>> getMemberInfo(String id) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();		
		
		MainMapper mainMapper = sqlSession.getMapper(MainMapper.class);
		
		list.addAll(mainMapper.getMemberInfo(id));
		
		return list;
	}

}
