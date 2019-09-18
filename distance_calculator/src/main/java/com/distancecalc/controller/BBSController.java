package com.distancecalc.controller;


import java.util.ArrayList;
import java.util.HashMap;

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

import com.distancecalc.common.Pagination;
import com.distancecalc.common.Search;
import com.distancecalc.service.BBSService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class BBSController {
	
	@Autowired
	private BBSService bbsService;
	
	private static final Logger logger = LoggerFactory.getLogger(BBSController.class);
	private static final String SUCCESS = "SUCCESS";
	private static final String FAILED = "FAILED";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public String bbs(
			 @RequestParam(required = false, defaultValue = "1") int page
			,@RequestParam(required = false, defaultValue = "1") int range
			,@RequestParam(required = false, defaultValue = "title") String searchType
			,@RequestParam(required = false) String keyword
			,Model model) 
	{
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
		Search search = new Search();

		search.setSearchType(searchType);

		search.setKeyword(keyword);
		
		int listCnt = bbsService.getBBSCnt(search);
		
		search.pageInfo(page, range, listCnt);
		
		list.addAll(bbsService.getBBS(search));
		
		model.addAttribute("pagination", search);
		model.addAttribute("data", list);
		
		return "bbs/bbs";
	}
	
	@RequestMapping(value = "/bbs/{idx}", method = RequestMethod.GET)
	public String bbsInfo(@PathVariable int idx, Model model) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		bbsService.updateBBSCount(idx);
		
		hashMap = bbsService.getBBSInfo(idx);
		
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsInfo"; 
	}

	@RequestMapping(value = "/bbs/write", method = RequestMethod.GET)
	public String bbsWrite(Model model) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsWrite";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbs/write.do", method = RequestMethod.POST)
	public String bbsWriteDo(@RequestParam HashMap<String, Object> map, Model model) {
		
		int result = bbsService.insertBBS(map);
		
		String data = result > 0 ? SUCCESS:FAILED;
		
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbs/delete.do", method = RequestMethod.POST)
	public String bbsDelete(@RequestParam("idx") int idx, Model model) {

		int result = bbsService.deleteBBS(idx);
		
		String data = result > 0 ? SUCCESS:FAILED;
		
		return data;
	}

	
	@RequestMapping(value = "/bbs/{idx}/update", method = RequestMethod.GET)
	public String bbsUpdate(@PathVariable int idx, Model model) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		hashMap = bbsService.getBBSInfo(idx);
		
		model.addAttribute("data", hashMap);
		
		return "bbs/bbsUpdate";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbs/{idx}/update.do", method = RequestMethod.POST)
	public String bbsUpdateDo(@RequestParam HashMap<String, Object> map, Model model) {
		
		int result = bbsService.updateBBS(map);

		String data = result > 0 ? SUCCESS:FAILED;
		
		return data;
	}
}
