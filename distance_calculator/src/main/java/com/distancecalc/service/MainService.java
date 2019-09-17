package com.distancecalc.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface MainService {
	
	public ArrayList<HashMap<String,Object>> getMemberInfo(String id);
}
