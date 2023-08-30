package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AppDemo {
	
	@RequestMapping("/add")
	public  ModelAndView add(HttpServletRequest request, HttpServletResponse responce) {
		int i=Integer.parseInt(request.getParameter("ashok"));
		int j=Integer.parseInt(request.getParameter("nagu"));
		int k=i+j;
		ModelAndView mv= new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",mv);
		System.out.println("loading aspect-1");
		return mv;
		

		
	}

}
