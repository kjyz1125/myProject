package com.eljamdev.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eljamdev.service.*;
import com.eljamdev.service.mapper.MainMapper;

@Repository
public class MainServiceImpl implements MainService {

	@Autowired
	private SqlSessionTemplate sqlSession;

}
