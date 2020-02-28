package com.eljamdev.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eljamdev.common.CommonMethod;
import com.eljamdev.common.FinalStringData;
import com.eljamdev.common.ValidationCheck;
import com.eljamdev.service.BBSService;
import com.eljamdev.service.MemberService;
import com.google.common.io.ByteStreams;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private BBSService bbsService;
	@Resource(name="uploadPath")
    String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
		list.addAll(bbsService.getHighestBBS());
		
		System.out.println(uploadPath);
		
		model.addAttribute("list", list);

		return "/main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		//model.addAttribute("returnUrl", CommonMethod.getReturnUrl(request, response));
		
		return "/login";
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
	
	@ResponseBody
	@RequestMapping(value = "/fileDownload.do", method = RequestMethod.GET, produces="application/octet-stream")
	public FileSystemResource fileDownload(HttpSession session
			,@RequestParam HashMap<String,Object> map
			,HttpServletRequest request
			,HttpServletResponse response) throws IllegalStateException, IOException 
	{
		String fileName = (String) map.get("real_file_name");
		String browser = request.getHeader("User-Agent");
		
		if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){		             
			 fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");		             
		 }else{		             
	    	fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");

		}    
		 
	    response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
	    response.setContentType("application/octer-stream");
	    response.setHeader("Content-Transfer-Encoding", "binary;");

    	File down_file = new File((String) bbsService.getFileDownload(map).get("real_file_path")); //파일 생성			
    	logger.info("저장된 파일명 : " + down_file.getName() + "실제 파일명 : " + fileName);

        return new FileSystemResource(down_file);
	}
}
