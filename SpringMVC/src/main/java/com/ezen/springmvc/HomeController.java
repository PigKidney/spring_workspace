package com.ezen.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Cook;

import commons.Calculator;
import model.Coffee;
import model.Department;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static Logger log = LogManager.getLogger(HomeController.class);
		
	@Autowired
	Cook cook;
	
	@Autowired
	Calculator calculator;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Coffee coffee = new Coffee();
		Department dept = new Department();
		
		// @NonNull 필드에 null을 넣으려는 경우 예외를 발생시켜준다
		try {
			coffee.setCoffee_id(null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		log.info(dept);
		log.info(coffee);
		
		log.fatal("Welcome to HomeController");
		log.error("Welcome to HomeController");
		log.warn("Welcome to HomeController");
		log.info("Welcome to HomeController");
		log.debug("Welcome to HomeController");
		log.trace("Welcome to HomeController");
		
		int a = calculator.diff(10, 13);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("cook", cook);
		return "home";
	}
	
}
