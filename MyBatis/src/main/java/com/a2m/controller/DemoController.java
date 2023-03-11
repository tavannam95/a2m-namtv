package com.a2m.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a2m.dao.DemoDAO;
import com.a2m.entities.Demo;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
	
	@Autowired
	DemoDAO dao;
	
	@GetMapping("")
	public ResponseEntity<?> getDemo(){
		List<Demo> list = dao.selectDemo();
		return ResponseEntity.ok(list);
	}
}
