package com.cjc.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.model.Student;

@RestController
public class HomeController {
	
	/*@RequestMapping("/")
	public String prelogin()
	{
		return"WEL_COME";
	}
     */
	@RequestMapping("/getStudent")
	public Student getStudent()
	{
		Student s=new Student();
		s.setSid(101);
		s.setUsername("ingle");
		s.setPassword("999999");
		
		return s;
	}
	@RequestMapping("/getEmp")
	public Employee getEmp()
	{
		Employee ee=new Employee();
		ee.setEid(111);
		ee.setEusername("Emp sachin");
		ee.setEpassword("PPPPPPP");
		return ee;
	}
}
