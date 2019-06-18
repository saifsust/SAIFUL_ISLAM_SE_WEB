package com.sweetitech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetitech.entities.Country;
import com.sweetitech.entities.TeamMember;
import com.sweetitech.repositories.CountryRepository;
import com.sweetitech.repositories.TeamMemberRepository;

@Service
public class TeamMemberService {
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	@Autowired
	private CountryRepository countryRepository;

	public void save(TeamMember mTeamMember, long countryId) {
		Country country = countryRepository.findCountryById(countryId);
		mTeamMember.setCountry(country);
		teamMemberRepository.save(mTeamMember);
	}

	public int delete(long teamMemberId) {
		return teamMemberRepository.deleteById(teamMemberId);
	}

	public TeamMember previous(long teamMemberId) {
		return teamMemberRepository.findTeamMemberByTeamMemberId(teamMemberId);
	}

	public int update(TeamMember teamMember, long teamMemberId, long countryId) {
		return teamMemberRepository.updateById(teamMember.getName(), teamMember.getAge(), teamMember.getDob(),
				teamMember.getRole(), countryId, teamMemberId);
	}

	public List<TeamMember> teamMemberDetail(String name) {
		Country country = countryRepository.findCountryByName(name);
		return teamMemberRepository.findTeamMemberByCountryId(country.countryId);
	}

}
