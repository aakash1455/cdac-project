package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Doner;
import com.app.service.IDonerServices;

@Controller
@RequestMapping("/user")
public class UserController
{
	// dependency
	@Autowired
	private IDonerServices service;

	public UserController() 
	{
		System.out.println("in def constr of " + getClass().getName());
	}

	
	@GetMapping("/login")
	public String showLoginForm() 
	{
		System.out.println("in show login form");
		return "/user/login";
	}

	
	@PostMapping("/login") 
	public String processLoginForm(Model map, 
			@RequestParam String email,
			@RequestParam String password,
			HttpSession hs)
	{
		System.out.println("in process login form");
		try
		{
			
			Doner v = service.validateUser(email, password);
			
			map.addAttribute("status", "Login Successful....");
			hs.setAttribute("user_dtls", v);
			if (v.getRole().equals("admin")) 
			{
					return "redirect:/admin/list";
			}
			
			return "/doner/details";
		} 
		catch (RuntimeException e) 
		{
			System.out.println("err in user controller " + e);
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			return "/user/login";
		}
		

	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession hs,Model map,
			HttpServletRequest request,HttpServletResponse response) {
		System.out.println("in user logout");
		map.addAttribute("dtls",hs.getAttribute("user_dtls"));	
		hs.invalidate();
		
		response.setHeader("refresh", 
				"5;url="+request.getContextPath());
		return "/user/logout";
	}
}
