package com.sweetitech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetitech.entities.Country;
import com.sweetitech.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public void save(Country mCountry) {
		countryRepository.save(mCountry);
	}

	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	public int delete(long countryId) {
		return countryRepository.deleteCountryById(countryId);
	}

	public int update(String name, long countryId) {
		return countryRepository.update(name, countryId);
	}

}
