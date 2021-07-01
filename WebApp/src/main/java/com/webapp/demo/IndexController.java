package com.webapp.demo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("home")
	public ModelAndView home(Keyboard keyboard) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", keyboard);
		mv.setViewName("home");
		return mv;
	}
	
	
	
}
