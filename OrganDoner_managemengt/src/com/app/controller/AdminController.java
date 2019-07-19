package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Doner;
import com.app.service.IAdminServices;
import com.app.service.IDonerServices;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	// dependency
	@Autowired
	private IAdminServices service;

	public AdminController()
	{
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() 
	{
		System.out.println("in show login form");
		return "/admin/login";
	}
	

	@PostMapping("/login") 
	public String processLoginForm(Model map, 
			@RequestParam String name,
			@RequestParam String password,
			HttpSession hs)
	{
		System.out.println("in process login form");
		try 
		{
			
			Admin a = service.validateAdmin(name, password);
			//service.validateAdmin(name, password);
			map.addAttribute("status", "Login Successful....");
			hs.setAttribute("admin_dtls", a);
			
			return "/admin/details";
		} 
		catch (RuntimeException e) 
		{
			System.out.println("err in user controller " + e);
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			return "/user/login";
		}
		

	}
	
	/*@GetMapping("/list")
	public String showDonerList(Model map)
	{
		System.out.println("in list Doner");
		
		map.addAttribute("Doner_list", service.listDoners());
		return "/admin/list"; 
	}
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int did,
			RedirectAttributes flashMap) 
	{
		System.out.println("in delete Doner "+did+" "+flashMap);
		flashMap.addFlashAttribute("status",service.deleteDoner(did));
			return "redirect:/admin/list"; 
	}
	@GetMapping("/add")
	public String showRegForm(Doner d)
	{
		System.out.println("in show reg form "+d);
			return "/admin/register"; 
	}
	@PostMapping("/add")
	public String processRegForm(Doner d,RedirectAttributes flashMap)
	{
		System.out.println("in process reg form "+d);
		
		flashMap.addFlashAttribute("status", service.registerDoner(d));
		return "redirect:/admin/list";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int did,Model map)
	{
		System.out.println("in show update form ");
		
		map.addAttribute("Doner",service.getDonerDetails(did));
		System.out.println(map);
		return "/admin/update";
	}
	@PostMapping("/update")
	public String processUpdateForm(Doner d,RedirectAttributes flashMap)
	{
		System.out.println("in process update "+d);
		
		flashMap.addFlashAttribute("status", service.updateDoner(d));
		return "redirect:/admin/list";
	}*/
	

}
