package commons;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ezen.springmvc.controller.HomeController;

public class Calculator {
	
	private static Logger log = LogManager.getLogger(HomeController.class);

	
	public int diff(int a, int b) {
		log.info("숫자차이 구함");
		return Math.abs(a-b);
	}
	
	public int noopDiff(int a, int b) {
		return a-b;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
}
