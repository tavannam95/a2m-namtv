package com.a2m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a2m.dao.UserDAO;
import com.a2m.jwt.JwtUtil;
import com.a2m.model.JwtRequest;
import com.a2m.model.JwtResponse;
import com.a2m.service.MyUserDetailsService;

@RestController
@RequestMapping("")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	UserDAO dao;

	@GetMapping("/hello")
	public String get() {
		return dao.getUserByUsername("user1").getRole();
	}

	@GetMapping("/hello2")
	public String get2() {
		return dao.getUserByUsername("user1").getRole();
	}

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Tài khoản hoặc mật khẩu sai", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(jwt));
	}
}
