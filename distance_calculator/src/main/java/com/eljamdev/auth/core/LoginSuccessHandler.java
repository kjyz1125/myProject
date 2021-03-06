package com.eljamdev.auth.core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.eljamdev.common.CommonMethod;
import com.eljamdev.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		//System.out.println("*****************login success*****************");

		ObjectMapper om = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("returnUrl", CommonMethod.getReturnUrl(request, response)); // 로그인 요청하기전 페이지 주소

		User member = (User) auth.getPrincipal();
		
		//System.out.println(auth.getCredentials());

		map.put("member", member);

		//System.out.println("auth::" + auth.getAuthorities());

		HttpSession session = request.getSession(true);

		session.setAttribute("name", member.getName());
		
		session.setAttribute("id", 	member.getId());

		session.setAttribute("memSq", member.getMemSq()); // 세션에 담아서 원래 페이지로 보냄

		String jsonString = om.writeValueAsString(map);
		
		//System.out.println(jsonString);
		
		OutputStream out = response.getOutputStream();
		out.write(jsonString.getBytes());

	}
}
