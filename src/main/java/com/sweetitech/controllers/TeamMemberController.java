package com.sweetitech.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sweetitech.entities.TeamMember;
import com.sweetitech.services.TeamMemberService;

@Controller("teamMemberController")
@RequestMapping(path = "/team")
public class TeamMemberController {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(TeamMemberController.class);

	@Autowired
	private TeamMemberService teamMemberService;

	@PostMapping(path = "/upload")
	public String upload(@ModelAttribute("member") TeamMember mTeamMember, @RequestParam("countryId") long countryId) {
		LOG.info("Team Member " + mTeamMember.toString());
		LOG.info("Country Id " + countryId);

		teamMemberService.save(mTeamMember, countryId);
		return "redirect:/";
	}

	@PostMapping(path = "/upload/{memberId}")
	public String update(@ModelAttribute("member") TeamMember teamMember, @PathVariable("memberId") long teamMemberId,
			@RequestParam("countryId") long countryId) {
		LOG.info("Team Member " + teamMember.toString());
		LOG.info("Country Id " + countryId);

		System.out.println(teamMemberId + "  " + teamMember + "  " + countryId);

		teamMemberService.update(teamMember, teamMemberId, countryId);

		return "redirect:/";
	}

	@PostMapping(path = "/members/country/{name}")
	@ResponseBody
	@CrossOrigin
	public List<TeamMember> team_members(@PathVariable("name") String name) {
		return teamMemberService.teamMemberDetail(name);
	}

	@GetMapping(path = "/previous/{team_member_id}")
	@ResponseBody
	@CrossOrigin
	public TeamMember previous(@PathVariable("team_member_id") long teamMemberId) {
		return teamMemberService.previous(teamMemberId);
	}

	@GetMapping(path = "/delete/{team_member_id}")
	public String delete(@PathVariable("team_member_id") long teamMemberId) {
		teamMemberService.delete(teamMemberId);
		return "redirect:/";
	}

}
