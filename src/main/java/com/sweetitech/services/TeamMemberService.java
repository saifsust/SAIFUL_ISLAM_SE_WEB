package com.sweetitech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetitech.entities.TeamMember;
import com.sweetitech.repositories.TeamMemberRepository;

@Service
public class TeamMemberService {
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	public void save(TeamMember mTeamMember) {
		teamMemberRepository.save(mTeamMember);
	}

	public int delete(long teamMemberId) {
		return teamMemberRepository.deleteById(teamMemberId);
	}

	public TeamMember previous(long teamMemberId) {
		return teamMemberRepository.findTeamMemberByTeamMemberId(teamMemberId);
	}

	public int update(TeamMember teamMember, long teamMemberId) {
		return teamMemberRepository.updateById(teamMember.getName(), teamMember.getAge(), teamMember.getDob(),
				teamMember.getRole(), teamMemberId);
	}

	public List<TeamMember> teamMemberDetail(long countryId) {
		return teamMemberRepository.findTeamMemberByCountryId(countryId);
	}

}
