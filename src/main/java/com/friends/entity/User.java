package com.friends.entity;

import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "address")
	private String address;
	@Column(name = "image_name")
	private String image;
	@Column(name = "mobile_num")
	private String mobilenum;
	@Column(name = "email_id")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "senderid", cascade = CascadeType.ALL)
	private Set<Connection> connection1;

	@JsonIgnore
	@OneToMany(mappedBy = "receiverid", cascade = CascadeType.ALL)
	private Set<Connection> connection2;

	@JsonIgnore
	@OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
	private Set<Friends> friends1;

	@JsonIgnore
	@OneToMany(mappedBy = "user2", cascade = CascadeType.ALL)
	private Set<Friends> friends2;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Connection> getConnection1() {
		return connection1;
	}

	public void setConnection1(Set<Connection> connection1) {
		this.connection1 = connection1;
	}

	public Set<Connection> getConnection2() {
		return connection2;
	}

	public void setConnection2(Set<Connection> connection2) {
		this.connection2 = connection2;
	}

	public Set<Friends> getFriends1() {
		return friends1;
	}

	public void setFriends1(Set<Friends> friends1) {
		this.friends1 = friends1;
	}

	public Set<Friends> getFriends2() {
		return friends2;
	}

	public void setFriends2(Set<Friends> friends2) {
		this.friends2 = friends2;
	}
	


	public User(Integer id, String firstname, String lastname, String address, String image, String mobilenum,
			String email, Set<Connection> connection1, Set<Connection> connection2, Set<Friends> friends1,
			Set<Friends> friends2) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.image = image;
		this.mobilenum = mobilenum;
		this.email = email;
		this.connection1 = connection1;
		this.connection2 = connection2;
		this.friends1 = friends1;
		this.friends2 = friends2;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}