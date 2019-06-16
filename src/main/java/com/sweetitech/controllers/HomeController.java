package com.sweetitech.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping(path = "/all_countries")
	@ResponseBody
	@CrossOrigin
	public List<Country> findCountry() {
		return countryService.getAllCountries();
	}

	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute("country") Country mCountry) {
		countryService.save(mCountry);
		return "redirect:/";
	}

	@RequestMapping(path = "/delete/{country_id}", method = RequestMethod.GET)
	public String country_delete(@PathVariable("country_id") long countryId) {
		countryService.delete(countryId);
		return "redirect:/";
	}

	@RequestMapping(path = "/update", method = RequestMethod.GET)
	public String country_update(@RequestParam("name") String name, @RequestParam("country_id") long countryId) {
		countryService.update(name, countryId);
		return "redirect:/";
	}

}
