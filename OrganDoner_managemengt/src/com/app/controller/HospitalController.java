package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.app.pojos.Hospital;
import com.app.service.IHospitalServices;

@Controller
@RequestMapping("/hospital")
public class HospitalController 
{
	@Autowired
	private IHospitalServices service;
	
	public HospitalController()
	{
		System.out.println("in constr of " + getClass().getName());
	}
	
	@GetMapping("/login")
	public String showLoginForm() 
	{
		System.out.println("in show login form");
		return "/hospital/login";
	}
	
	@PostMapping("/login") 
	public String processLoginForm(Model map, 
			@RequestParam String hospitalName,
			@RequestParam String password,
			HttpSession hs)
	{
		System.out.println("in process login form");
		try 
		{
			
			Hospital a = service.validateHospital(hospitalName, password);
			
			map.addAttribute("status", "Login Successful....");
			hs.setAttribute("hospital_dtls", a);
			
			return "/hospital/details";
		} 
		catch (RuntimeException e) 
		{
			System.out.println("error in hospital controller " + e);
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			return "/hospital/login";
		}
		
}
}
