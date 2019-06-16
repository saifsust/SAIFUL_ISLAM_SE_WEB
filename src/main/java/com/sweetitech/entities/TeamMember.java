package com.sweetitech.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "icc_team_members")
public class TeamMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_member_id")
	private long teamMemberId;
	@Column(name = "name")
	private String name;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "age")
	private double age;
	@Column(name = "role")
	private String role;
	@JoinColumn(name = "country_id")
	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true, targetEntity = Country.class)
	private Country coumtry;

	public TeamMember() {
		super();
	}

	public TeamMember(String name, Date dob, double age, String role, Country coumtry) {
		super();
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.role = role;
		this.coumtry = coumtry;
	}

	public long getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(long teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Country getCoumtry() {
		return coumtry;
	}

	public void setCoumtry(Country coumtry) {
		this.coumtry = coumtry;
	}

	@Override
	public String toString() {
		return "TeamMember [teamMemberId=" + teamMemberId + ", name=" + name + ", dob=" + dob + ", age=" + age
				+ ", role=" + role + ", coumtry=" + coumtry + "]";
	}

}