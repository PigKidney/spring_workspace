package com.ezen.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jdk.internal.org.jline.utils.Log;
import model.Coffee;
import model.Department;

@RequestMapping("/hello")
@Controller
public class HelloController {
	private static Logger log = LogManager.getLogger(HelloController.class);

	
	@RequestMapping("/index")
	String index(HttpServletRequest request , HttpServletResponse resonse) {
		
		request.setAttribute("dept", new Department());
		
		// /WEB-INF/views와 확장자 .jsp를 제외한 주소를 리턴하면 알맞은 뷰를 찾아감
		// servlet-context.xml에 관련 설정이 있음
		return "hello/index";
	}
	
	@RequestMapping(value = {"/hi","/greetings"})
	String greeting() {
		return "hello/greetings";
	}
	
	@RequestMapping(value = "/parameter", method = RequestMethod.GET)
	String paraForm() {
		return "hello/parameter";
	}
	
	@RequestMapping(value = "/parameter", method = RequestMethod.POST)
	String para(Department dept) {
		// request.getParameter()로 노가다 하지 않았는데 알아서 인스턴스화 되어있다...
		log.info(dept);
		
		// request.setParameter()로 추가한적도 없는데 알아서 추가 되어있다...
		return "hello/paraResult";
	}
	
	@RequestMapping(value = "/para2", method = RequestMethod.POST)
	String para2(Integer employee_id) {
		log.info("employee_id : "+employee_id);
		return "hello/result2";
	}
	
	@RequestMapping(value = "/para3", method = RequestMethod.POST)
	String para3(@ModelAttribute("employee_id") Integer emp_id) {
		log.info("emp_id : "+emp_id);
		return "hello/result2";
	}
	
	@RequestMapping("/cookie/")
	String cookieIndex() {
		return "hello/cookie/index";
	}
	
	@RequestMapping("/cookie/set")
	String setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("age", "10");
		response.addCookie(cookie);
		response.addCookie(new Cookie("hobby", "cooking"));
		response.addCookie(new Cookie("movie", "타짜"));

		return "redirect:/hello/cookie/";
	}
	
	@RequestMapping("/cookie/check")
	String checkDookie(
			@CookieValue Integer age,
			@CookieValue("movie") String moive,
			@CookieValue String hobby
			) {
		log.info("age : "+age);
		log.info("movie :"+moive);
		log.info("hobby : "+hobby);
		
		return "redirect:/hello/cookie/";
	}
	
	// 아무것도 안써도 /WEB-INF/views/hello/return/void.jsp를 찾아간다
	@RequestMapping("/return/void")
	void returnPage() {}
	
	// ModelAndView : 짐 싣는 역활과 다음 페이지로 가는 역할을 한데 묶은 객체
	@RequestMapping("/return/mvc")
	ModelAndView returnPage2() {
		ModelAndView mnv = new ModelAndView();
		
		// Model의 짐 싣는 역할도 하고
		mnv.addObject("dept", new Department());
		
		// String의 다음 뷰로 안내하는 역할도 하는 객체
		mnv.setViewName("/hello/return/mnv");
		
		
		return mnv;
	}
}

