package com.eljamdev.common;

import java.util.HashMap;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationCheck {
	
	private static final Logger logger = LoggerFactory.getLogger(ValidationCheck.class);

	public boolean joinValidationCheck(HashMap<String,Object> hashMap) {
				
		boolean result = false;
	
		try {
			
			if(Pattern.compile(FinalStringData.COMMON_REGEX).matcher((String) hashMap.get("id")).matches()
				&& Pattern.compile(FinalStringData.EMAIL_REGEX).matcher((String) hashMap.get("email")).matches()){
				result = true;
			}else {
				result = false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	
		return result;
	}
	
}
