package com.distancecalc.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface MainMapper {
	public ArrayList<HashMap<String, Object>> getMemberInfo(String id);
}
