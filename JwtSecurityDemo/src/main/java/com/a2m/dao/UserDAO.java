package com.a2m.dao;

import org.apache.ibatis.annotations.Mapper;

import com.a2m.entities.User;

@Mapper
public interface UserDAO {
	
	User getUserByUsername(String username);
}
