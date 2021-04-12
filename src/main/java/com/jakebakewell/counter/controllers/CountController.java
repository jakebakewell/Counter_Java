package com.jakebakewell.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpSession session) {
		if (session.getAttribute("count") != null) {
			Integer count = (Integer) session.getAttribute("count");
			count += 1;
			session.setAttribute("count", count);
			return "index.jsp";
		}
		else {
			session.setAttribute("count", 1);
			return "index.jsp";
		}
	}
	
	@RequestMapping(value="/counter", method=RequestMethod.GET)
	public String counter(HttpSession session) {
		return "counter.jsp";
	}
	
	@RequestMapping(value="/countbytwo", method=RequestMethod.GET)
	public String twoCount(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count += 2;
		session.setAttribute("count", count);
		return "counter.jsp";
	}
	
	@RequestMapping(value="/clear", method=RequestMethod.GET)
	public String clear(HttpSession session) {
		session.invalidate();
		return "counter.jsp";
	}
}
