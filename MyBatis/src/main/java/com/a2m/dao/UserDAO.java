package com.a2m.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.a2m.entities.User;

@Mapper
public interface UserDAO {
	List<User> selectUser();
}
