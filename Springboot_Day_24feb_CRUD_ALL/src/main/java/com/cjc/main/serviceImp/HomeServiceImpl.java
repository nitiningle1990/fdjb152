package com.cjc.main.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.servicei.HomeServiceI;
@Service
public class HomeServiceImpl implements HomeServiceI{

	@Autowired
	HomeRepository hr;
	
	@Override
	public void saveDate(Student s) {
		
		hr.save(s);
		
	}

	@Override
	public void logincheck(String un, String ps) {
		
		hr.findAllByUsernameAndPassword(un,ps);
		
	}

	@Override
	public Iterable displayAllData() {
		
		return hr.findAll();
	}

}
