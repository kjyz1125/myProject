package com.eljamdev.common;

public class FinalStringData {

	public static final String SUCCESS = PropertiesConfiguration.getString("config.properties", "success");
	public static final String FAILED = PropertiesConfiguration.getString("config.properties", "failed");
	
	
	public static final String BBS_CATEGORY = PropertiesConfiguration.getString("config.properties", "bbs_category");
	public static final String DEVOPS_CATEGORY = PropertiesConfiguration.getString("config.properties", "devops_category");
	public static final String SPRING_CATEGORY = PropertiesConfiguration.getString("config.properties", "spring_category");
	
	public static final String BBS_TITLE = PropertiesConfiguration.getString("config.properties", "title_bbs");
	public static final String DEVOPS_TITLE = PropertiesConfiguration.getString("config.properties", "title_devops");
	public static final String SPRING_TITLE = PropertiesConfiguration.getString("config.properties", "title_spring");
	
	public static final String COMMON_REGEX = PropertiesConfiguration.getString("config.properties", "common_regex");
	public static final String EMAIL_REGEX = PropertiesConfiguration.getString("config.properties", "email_regex");
	
	public static final String ROLE_ADMIN = PropertiesConfiguration.getString("config.properties", "role_admin");
	public static final String ROLE_USER = PropertiesConfiguration.getString("config.properties", "role_user");
}
