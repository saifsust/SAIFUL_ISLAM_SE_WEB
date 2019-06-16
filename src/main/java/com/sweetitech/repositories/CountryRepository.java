package com.sweetitech.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM icc_countries WHERE country_id= :country_id", nativeQuery = true)
	public int deleteCountryById(@Param("country_id") long countryId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE icc_countries SET name= :name WHERE country_id=:country_id", nativeQuery = true)
	public int update(@Param("name") String name, @Param("country_id") long countryId);

}
