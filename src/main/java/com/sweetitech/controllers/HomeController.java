package com.sweetitech.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sweetitech.entities.Country;
import com.sweetitech.services.CountryService;

@Controller
public class HomeController {

	private ModelAndView mnv;

	private static final String INDEX = "index";

	@Autowired
	private CountryService countryService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		mnv = new ModelAndView(INDEX);
		request.setAttribute("countries", countryService.getAllCountries());
		return mnv;
	}

	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute("country") Country mCountry) {
		countryService.save(mCountry);
		return "redirect:/";
	}

}
