package com.sweetitech.repositories;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sweetitech.entities.TeamMember;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {

	@Transactional
	@Query(value = "SELECT * FROM icc_team_members JOIN icc_countries ON icc_team_members.counrty_id=icc_countries.country_id and icc_team_members.team_member_id=:team_member_id", nativeQuery = true)
	public TeamMember findTeamMemberByTeamMemberId(@Param("team_member_id") long teamMemberId);

	@Transactional
	@Query(value = "SELECT * FROM icc_team_members JOIN icc_countries ON icc_team_members.country_id=icc_countries.country_id and icc_team_members.country_id=:country_id", nativeQuery = true)
	public List<TeamMember> findTeamMemberByCountryId(@Param("country_id") long countryId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE icc_team_members SET name=:name,age=:age,dob=:dob,role=:role WHERE team_member_id=:team_member_id", nativeQuery = true)
	public int updateById(@Param("name") String name, @Param("age") double age, @Param("dob") Date dob,
			@Param("role") String role, @Param("team_member_id") long teamMemberId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE icc_team_members SET name=:name WHERE team_member_id=:team_member_id", nativeQuery = true)
	public int updateNameById(@Param("name") String name, @Param("team_member_id") long teamMemberId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE icc_team_members SET dob=:dob WHERE team_member_id=:team_member_id", nativeQuery = true)
	public int updateDOBById(@Param("dob") Date dob, @Param("team_member_id") long teamMemberId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE icc_team_members SET age=:age WHERE team_member_id=:team_member_id", nativeQuery = true)
	public int updateAgeById(@Param("age") double age, @Param("team_member_id") long teamMemberId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE icc_team_members SET role=:role WHERE team_member_id=:team_member_id", nativeQuery = true)
	public int updateRoleById(@Param("role") String role, @Param("team_member_id") long teamMemberId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM icc_team_members WHERE team_member_id=:team_member_id", nativeQuery = true)
	public int deleteById(@Param("team_member_id") long teamMemberId);

}
