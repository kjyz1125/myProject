package com.distancecalc.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.distancecalc.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {

		return "main";
	}
	
	@RequestMapping(value = "/dc", method = RequestMethod.GET)
	public String distance_calculator(Locale locale, Model model) {
		
		return "dc";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(HttpServletResponse res, Model model) {
		
		res.setStatus(HttpServletResponse.SC_OK);
		
		return "common/error404";
	}
	
}
