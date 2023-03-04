package com.a2m.domain.DTO;

import lombok.Data;

public class UserDTO {
	private String username;
	private String fullname;
	private int age;
	
	public UserDTO() {
	}

	public UserDTO(String username, String fullname, int age) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
