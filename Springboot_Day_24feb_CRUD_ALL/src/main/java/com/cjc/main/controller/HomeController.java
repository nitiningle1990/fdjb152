package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Student;
import com.cjc.main.servicei.HomeServiceI;

@Controller
public class HomeController {
	@Autowired
	HomeServiceI hsi;
	
	@RequestMapping("/")
	public String prelogin()
	{
		return"login";
	}
	@RequestMapping("/registerpage")
	public String preRegister()
	{
		return"register";
	}
	@RequestMapping("/save")
	public String saveDate(@ModelAttribute Student s)
	{
		hsi.saveDate(s);
		return"login";
	}
	@RequestMapping("/login")
	public String logincheck(@RequestParam("username") String un,@RequestParam("password") String ps,Model m)
	{
		System.out.println(un);
        System.out.println(ps);	
        hsi.logincheck(un,ps);
        Iterable list=hsi.displayAllData(); 
        m.addAttribute("data", list);
        return"success";
	}
	
}
