package com.eljamdev.common;

public class FinalStringData {

	public static final String SUCCESS = PropertiesConfiguration.getString("config.properties", "success");
	public static final String FAILED = PropertiesConfiguration.getString("config.properties", "failed");
	public static final String BBS_CATEGORY = PropertiesConfiguration.getString("config.properties", "bbs_category");
	public static final String DEVOPS_CATEGORY = PropertiesConfiguration.getString("config.properties", "devops_category");
	public static final String COMMON_REGEX = PropertiesConfiguration.getString("config.properties", "common_regex");
	public static final String EMAIL_REGEX = PropertiesConfiguration.getString("config.properties", "email_regex");
}
