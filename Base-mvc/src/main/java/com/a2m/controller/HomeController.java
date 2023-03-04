package com.a2m.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.a2m.dao.UserDAO;
import com.a2m.domain.DTO.UserDTO;

@Controller
public class HomeController {
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("home");
	      return mav;
	   }
	  
	   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
	   public ModelAndView springMVCPage(Model model) {
	      ModelAndView mav = new ModelAndView("springmvc");
	      return mav;
	   }
	   @RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView getViewUser() {
		   ModelAndView modelAndView = new ModelAndView("user");
		   return modelAndView;
	   }
	   
	   @RequestMapping(value = "/user", method = RequestMethod.POST)
	   public ModelAndView post(@ModelAttribute UserDTO userDTO, Model model) {
		   System.out.println(userDTO.getUsername());
		   UserDAO dao = new UserDAO();
		   dao.create(userDTO);
		   ModelAndView modelAndView = new ModelAndView("user");
		   return modelAndView;
	   }
}
