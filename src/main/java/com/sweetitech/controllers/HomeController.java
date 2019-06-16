package com.sweetitech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private ModelAndView mnv;

	private static final String INDEX = "index";

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return INDEX;
	}

}
