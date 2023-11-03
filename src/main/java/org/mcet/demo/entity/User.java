package org.mcet.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MASTER")
public class User {
	@Id
	//@GeneratedValue cannot be used on String. It can be used only on Integer, Long, Short, Byte
	private String username;
	private String password;
	private String fullname;
	private String email;	
	private String phoneNo;
	
	public User() {}

	public User(String username, String password, String fullname, String email, String phoneNo) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullname=" + fullname + ", email=" + email
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	
}
