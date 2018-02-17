package com.chandi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chandi.service.UserService;

@RestController
public class DashboardController {
	
	@Autowired
	private UserService userService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("users", userService.getUsers());
    	model.setViewName("dashboard");
    	return model;
    }

}
