package com.eljamdev.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eljamdev.common.Pagination;
import com.eljamdev.common.Search;
import com.eljamdev.service.*;
import com.eljamdev.service.mapper.BBSMapper;
import com.eljamdev.service.mapper.MainMapper;

@Repository
public class BBSServiceImpl implements BBSService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<HashMap<String, Object>> getBBS(Pagination pagination) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();		
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		list.addAll(bbsMapper.getBBS(pagination));
		
		return list;
	}

	@Override
	public HashMap<String, Object> getBBSInfo(int idx) {
		HashMap<String, Object> hashMap = new HashMap<>();		
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		hashMap = bbsMapper.getBBSInfo(idx);
		
		return hashMap;
	}

	@Override
	public int insertBBS(HashMap<String,Object> map) {
	
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		return bbsMapper.insertBBS(map);
	}

	@Override
	public int deleteBBS(int idx) {
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		return bbsMapper.deleteBBS(idx);
	}

	@Override
	public int updateBBS(HashMap<String, Object> map) {
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		return bbsMapper.updateBBS(map);
	}

	@Override
	public void updateBBSCount(int idx) {
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		bbsMapper.updateBBSCount(idx);
	}

	@Override
	public int getBBSCnt(Search search) {
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		return bbsMapper.getBBSCnt(search);
	}

	@Override
	public ArrayList<HashMap<String, Object>> getHigestBBS() {

		ArrayList<HashMap<String, Object>> list = new ArrayList<>();		
		
		BBSMapper bbsMapper = sqlSession.getMapper(BBSMapper.class);
		
		list.addAll(bbsMapper.getHighestBBS());
		
		return list;
	}

}
