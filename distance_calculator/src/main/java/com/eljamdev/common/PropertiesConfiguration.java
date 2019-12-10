package com.eljamdev.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.eljamdev.controller.BBSController;

public class PropertiesConfiguration {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesConfiguration.class);
	private static final String ROOTPATH = "properties/";
	
	
	private static String _getProperties(String strModule, String strKey) {
		Properties props = new Properties();
		InputStream is = null;
		String strResult = null;
		try {
			File f = new ClassPathResource(ROOTPATH+strModule).getFile();
			is = new FileInputStream(f);
			props.load(is);
			strResult = props.getProperty(strKey);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally{
			if(is != null){
				try {
					is.close(); 
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		return strResult;
	}
	
	public static String getString(String strModule, String strKey) {
		return _getProperties(strModule, strKey);
	}
	
}
