package org.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.example.config.Gender;

@Entity
@Table(name = "user")
public class User {

	public User() {
		
	}

	public User(String firstname, String lastname, Gender gender) {

		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setGnder(gender);
		this.setBirthdate(new Date());
		this.setHiredate(new Date());

	}

	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@CreationTimestamp
	private Date birthdate;

	private String firstname;

	private String lastname;

	// @Column(columnDefinition = "ENUM('r', 'w', 'i')")
	// @org.hibernate.annotations.ColumnDefault("'i'")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@CreationTimestamp
	private Date hiredate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGnder(Gender gender) {
		this.gender = gender;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

}