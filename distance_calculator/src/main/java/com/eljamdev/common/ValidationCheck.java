package com.eljamdev.common;

import java.util.HashMap;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationCheck {
	
	private static final Logger logger = LoggerFactory.getLogger(ValidationCheck.class);

	public boolean joinValidationCheck(HashMap<String,Object> hashMap) {
		
		String id ="";
		String email="";
				
		boolean result = false;
		
		id = (String) hashMap.get("id");
		email = (String) hashMap.get("email");
		
		try {
			if(Pattern.compile(FinalStringData.COMMON_REGEX).matcher(id).matches()){
				if(!email.equals("")) {
					result = Pattern.compile(FinalStringData.EMAIL_REGEX).matcher(email).matches();
				}
			}else {
				result = false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	
		return result;
	}
	
}
