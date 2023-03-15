package com.a2m.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.a2m.dao.UserDAO;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	UserDAO dao;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		
		List<com.a2m.entities.User> list = dao.selectUser();
		
		List<UserDetails> listUserDetails = new ArrayList<>();
		
		for (com.a2m.entities.User user : list) {
			UserDetails userDetails = User.withUsername(user.getUsername())
		            .password(user.getPassword())
		            .roles(user.getRole())
		            .build();
			listUserDetails.add(userDetails);
			
		}
		return new InMemoryUserDetailsManager(listUserDetails);
		
//		UserDetails user1 = User.withUsername("user1")
//	            .password(passwordEncoder().encode("123"))
//	            .roles("USER")
//	            .build();
//	        UserDetails user2 = User.withUsername("user2")
//	            .password(passwordEncoder().encode("123"))
//	            .roles("USER")
//	            .build();
//	        UserDetails admin = User.withUsername("admin")
//	            .password(passwordEncoder().encode("123"))
//	            .roles("ADMIN")
//	            .build();
//	        return new InMemoryUserDetailsManager(user1,user2,admin);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/home","/login","/api/v1/demo/**","/login-success","/login-error").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/login-success")
			.failureUrl("/login-error")
			.and()
			.logout()
		 	.logoutUrl("/logout")
			.logoutSuccessUrl("/home")
			;
		return http.build();
	}
}
