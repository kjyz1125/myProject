package com.eljamdev.controller;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eljamdev.common.FinalStringData;
import com.eljamdev.common.Pagination;
import com.eljamdev.common.PropertiesConfiguration;
import com.eljamdev.common.Search;
import com.eljamdev.service.BBSService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class BBSController {
	
	@Autowired
	private BBSService bbsService;
	
	private static final Logger logger = LoggerFactory.getLogger(BBSController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public String bbs(
			 @RequestParam(required = false, defaultValue = "1") int page
			,@RequestParam(required = false, defaultValue = "1") int range
			,@RequestParam(required = false, defaultValue = "title") String searchType
			,@RequestParam(required = false, defaultValue = "C") String category
			,@RequestParam(required = false) String keyword
			,Model model) 
	{
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		Search search = new Search();

		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setCategory(category);
		
		int listCnt = bbsService.getBBSCnt(search);
		
		search.pageInfo(page, range, listCnt);
		
		list.addAll(bbsService.getBBS(search));
		
		model.addAttribute("title", "BBS");
		model.addAttribute("pagination", search);
		model.addAttribute("data", list);
		model.addAttribute("count", listCnt);
		
		return "bbs/bbs";
	}
	
	@RequestMapping(value = "/bbs/{idx}", method = RequestMethod.GET)
	public String bbsInfo(HttpServletRequest request, @PathVariable int idx, Model model) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		bbsService.updateBBSCount(idx);
		
		hashMap = bbsService.getBBSInfo(idx);
		
		model.addAttribute("title", "BBSInfo");
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsInfo"; 
	}

	@RequestMapping(value = "/bbs/write", method = RequestMethod.GET)
	public String bbsWrite(Model model) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		model.addAttribute("title", "BBSWrite");
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsWrite";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbs/write.do", method = RequestMethod.POST)
	public String bbsWriteDo(HttpServletRequest request, @RequestParam HashMap<String, Object> map, Model model) {
		
		int result = 0;
		String data = "";
		HttpSession session = request.getSession(true);
		
		map.put("id"  , session.getAttribute("id"));
		map.put("name"  , session.getAttribute("name"));
		map.put("category", FinalStringData.BBS_CATEGORY);
		
		result = bbsService.insertBBS(map);
		data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
		
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbs/delete.do", method = RequestMethod.POST)
	public String bbsDelete(HttpServletRequest request, @RequestParam("idx") int idx, Model model) {
		
		int result = 0;
		String id = "";
		HashMap<String, Object> hashMap = new HashMap<>();
		HttpSession session = request.getSession(true);
		
		hashMap = bbsService.getBBSInfo(idx);
		id = (String) hashMap.get("id");
		
		if(session.getAttribute("id").equals(id)) {	
			result = bbsService.deleteBBS(idx);
			String data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
			return data;
		}else{
			
			String data = FinalStringData.FAILED;
			return data;
		}
		
		
	}

	
	@RequestMapping(value = "/bbs/{idx}/update", method = RequestMethod.GET)
	public String bbsUpdate(HttpServletRequest request, @PathVariable int idx, Model model) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		HttpSession session = request.getSession(true);
		
		session.setAttribute("id", request.getSession().getAttribute("id"));
		hashMap = bbsService.getBBSInfo(idx);
		
		model.addAttribute("title", "BBSModify");
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsUpdate";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbs/{idx}/update.do", method = RequestMethod.POST)
	public String bbsUpdateDo(HttpServletRequest request, @PathVariable int idx, @RequestParam HashMap<String, Object> map, Model model) {

		int result = 0;
		String id = "";
		HashMap<String, Object> hashMap = new HashMap<>();
		HttpSession session = request.getSession(true);
		
		hashMap = bbsService.getBBSInfo(idx);
		id = (String) hashMap.get("id");
		
		if(session.getAttribute("id").equals(id)) {	
			result = bbsService.updateBBS(map);
			String data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
			return data;
		}else{	
			String data = FinalStringData.FAILED;
			return data;
		}	
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/devOps", method = RequestMethod.GET)
	public String devOps(
			 @RequestParam(required = false, defaultValue = "1") int page
			,@RequestParam(required = false, defaultValue = "1") int range
			,@RequestParam(required = false, defaultValue = "title") String searchType
			,@RequestParam(required = false, defaultValue = "D") String category
			,@RequestParam(required = false) String keyword
			,Model model) 
	{
		int listCnt = 0;
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		Search search = new Search();

		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setCategory(category);
		
		listCnt = bbsService.getBBSCnt(search);
		search.pageInfo(page, range, listCnt);
		list.addAll(bbsService.getBBS(search));
		
		model.addAttribute("title", "DevOps");
		model.addAttribute("pagination", search);
		model.addAttribute("data", list);
		model.addAttribute("count", listCnt);
		
		return "bbs/bbs";
	}
	
	@RequestMapping(value = "/devOps/{idx}", method = RequestMethod.GET)
	public String devOpsInfo(@PathVariable int idx, Model model) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		bbsService.updateBBSCount(idx);
		
		hashMap = bbsService.getBBSInfo(idx);
		
		model.addAttribute("title", "DevOpsInfo");
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsInfo"; 
	}

	@RequestMapping(value = "/devOps/write", method = RequestMethod.GET)
	public String devOpsWrite(Model model) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		model.addAttribute("title", "DevOpsWrite");
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsWrite";
	}
	
	@ResponseBody
	@RequestMapping(value = "/devOps/write.do", method = RequestMethod.POST)
	public String devOpsWriteDo(HttpServletRequest request, @RequestParam HashMap<String, Object> map, Model model) {
		
		int result = 0;
		String data = "";
		HttpSession session = request.getSession(true);
		
		map.put("id"  , session.getAttribute("id"));
		map.put("name"  , session.getAttribute("name"));
		map.put("category", FinalStringData.DEVOPS_CATEGORY);
		
		result = bbsService.insertBBS(map);
		data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
		
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/devOps/delete.do", method = RequestMethod.POST)
	public String devOpsDelete(HttpServletRequest request, @RequestParam("idx") int idx, Model model) {

		int result = 0;
		String id = "";
		HashMap<String, Object> hashMap = new HashMap<>();
		HttpSession session = request.getSession(true);
		
		hashMap = bbsService.getBBSInfo(idx);
		id = (String) hashMap.get("id");
		
		if(session.getAttribute("id").equals(id)) {	
			result = bbsService.deleteBBS(idx);
			String data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
			return data;
		}else{
			
			String data = FinalStringData.FAILED;
			return data;
		}
	}

	
	@RequestMapping(value = "/devOps/{idx}/update", method = RequestMethod.GET)
	public String devOpsUpdate(@PathVariable int idx, Model model) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		hashMap = bbsService.getBBSInfo(idx);
		
		model.addAttribute("title", "DevOpsModify");
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsUpdate";
	}
	
	@ResponseBody
	@RequestMapping(value = "/devOps/{idx}/update.do", method = RequestMethod.POST)
	public String devOpsUpdateDo(HttpServletRequest request, @PathVariable int idx, @RequestParam HashMap<String, Object> map, Model model) {
		
		int result = 0;
		String id = "";
		HashMap<String, Object> hashMap = new HashMap<>();
		HttpSession session = request.getSession(true);
		
		hashMap = bbsService.getBBSInfo(idx);
		id = (String) hashMap.get("id");
		
		if(session.getAttribute("id").equals(id)) {	
			result = bbsService.updateBBS(map);
			String data = result > 0 ? FinalStringData.SUCCESS:FinalStringData.FAILED;
			return data;
		}else{	
			String data = FinalStringData.FAILED;
			return data;
		}	
	}
}
