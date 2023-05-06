package com.cjc.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.serviceI.HomeServiceI;

@Service
public class HomeServiceImpl implements HomeServiceI {
    @Autowired
	HomeRepository hr;
    
	@Override
	public void saveData(Student s) {
		
		hr.save(s);
	}
	@Override
	public Iterable displayAllData() {
		
		 Iterable list =hr.findAll();
		return list;
	}

	@Override
	public Student logincheck(String username, String password) {
		 
		Student ss=hr.findAllByUsernameAndPassword(username, password);
		return ss;
	}

	@Override
	public void StudentData(int sid) {
		
		hr.deleteById(sid); 
		
	}
		

}
