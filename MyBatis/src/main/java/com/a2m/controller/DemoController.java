package com.a2m.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a2m.dao.DemoDAO;
import com.a2m.dao.UserDAO;
import com.a2m.entities.Demo;
import com.a2m.entities.User;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
	
	@Autowired
	DemoDAO dao;
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("")
	public ResponseEntity<?> getDemo(){
		List<Demo> list = dao.selectDemo();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("")
	public ResponseEntity<?> setDemo(@RequestBody String name){
		
		Demo demo = new Demo();
		demo.setName(name);
		
		dao.insertDemo(demo);
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> getUser(){
		List<User> user = userDAO.selectUser();
		return ResponseEntity.ok(user);
	}
}
