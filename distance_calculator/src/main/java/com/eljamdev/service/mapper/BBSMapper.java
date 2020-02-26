package com.eljamdev.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.eljamdev.common.Pagination;
import com.eljamdev.common.Search;

@Service
public interface BBSMapper {
	
	public ArrayList<HashMap<String, Object>> getBBS(Pagination pagination);
	public HashMap<String, Object> getBBSInfo(int idx);
	public int insertBBS(HashMap<String,Object> map);
	public int deleteBBS(int idx);
	public int updateBBS(HashMap<String,Object> map);
	public void updateBBSCount(int idx);
	public int getBBSCnt(Search search);
	public ArrayList<HashMap<String, Object>> getHighestBBS();
}
