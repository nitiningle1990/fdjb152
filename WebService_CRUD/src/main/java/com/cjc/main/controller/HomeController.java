 package com.cjc.main.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Student;
import com.cjc.main.serviceI.HomeServiceI;

@RestController
@CrossOrigin("*")//conection for angular
public class HomeController {
	
	@Autowired
	HomeServiceI hsi;
  //post insert
	@RequestMapping(value ="/StudentSave",method =RequestMethod.POST)
	public String StudentSave(@RequestBody Student s)
	{
		hsi.saveData(s);
		
		return"success";
	}
	//get 
	@RequestMapping(value ="/getAllData",method =RequestMethod.GET)
	public Iterable getListData()
	{
		Iterable list=hsi.displayAllData();
		
		return list;
	}
	//single get
	@GetMapping(value = "/getSingleData/{un}/{ps}")
	public Student getSingleData(@PathVariable("un") String username,@PathVariable("ps") String password)
	{
	Student stu=hsi.logincheck(username,password);  
		
	return stu;
	}
	
	//put method
	@PutMapping(value="/updateput/{sid}")
	public String updateData(@PathVariable("sid") int sid,@RequestBody Student s)
	{
		hsi.saveData(s);
		return "update";  
	}
	
	//delete method
	@DeleteMapping(value = "/deleteStu/{sid}")
	public String DeleteData(@PathVariable("sid") int sid)
	{
		hsi.StudentData(sid);
		return "delete";
	}
	
	@PatchMapping(value="/updatepatch/{sid}")
	public String updateAllData(@PathVariable("sid") int sid,@RequestBody Student s)
	{
		hsi.saveData(s);
		return "update";
	}
	
	
}
