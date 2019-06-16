package com.sweetitech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sweetitech.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	@Query(value = "SELECT * FROM icc_countries WHERE country_id=:country_id", nativeQuery = true)
	public Country findCountryById(@Param("country_id") long countryId);

	@Query(value = "SELECT * FROM icc_countries WHERE name = :name", nativeQuery = true)
	public Country findCountryByName(@Param("name") String name);

}
