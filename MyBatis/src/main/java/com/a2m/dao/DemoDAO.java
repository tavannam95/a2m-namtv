package com.a2m.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.a2m.entities.Demo;

@Mapper
public interface DemoDAO {

	List<Demo> selectDemo();
	
	void insertDemo(Demo demo);
	
}
