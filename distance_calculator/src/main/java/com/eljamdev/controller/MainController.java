package com.eljamdev.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eljamdev.common.FinalStringData;
import com.eljamdev.common.ValidationCheck;
import com.eljamdev.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {

		return "/main";
	}
	
	
	@RequestMapping(value = "/dc", method = RequestMethod.GET)
	public String distance_calculator(Locale locale, Model model) {
		
		return "/dc";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(HttpServletResponse res, Model model) {
		
		res.setStatus(HttpServletResponse.SC_OK);
		
		return "common/error404";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session, Model model)
	{

		return "/join";
	}
	
	@ResponseBody
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String doJoin(HttpSession session
			,@RequestParam HashMap<String,Object> map
			,HttpServletRequest request
			,HttpServletResponse response) throws IllegalStateException, IOException 
	{
		String data = "";
		ValidationCheck vc = new ValidationCheck();
		
		if(vc.joinValidationCheck(map)) {
			int result = memberService.insertMember(map);
			data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
		}else {
			data = FinalStringData.FAILED;
		}
		
		return data;

	}
	
}
