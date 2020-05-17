package com.demo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated 
//good practice to have these validation annotation
public class User {
 
	private int id;
	
	@Size(min = 4, max = 30, message = "Name should be b/w 4 to 30 char")
	private String name;

	@Size(min = 4, max = 30, message = "UserName should be b/w 4 to 30 char")
	private String username;

	@Size(min = 8, max = 15, message = "Password should be b/w 8 to 15 char")
	private String password;
	
	@Size(min = 8, max = 15, message = "Re-password should be b/w 8 to 15 char")
	private String repassword;

	@Pattern(regexp = "\\w+\\@\\w{1,3}", message = "Please Enter valid E-mail ID") //abc@.com
	private String emailid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", repassword=" + repassword + ", emailid=" + emailid + "]";
	}


}
