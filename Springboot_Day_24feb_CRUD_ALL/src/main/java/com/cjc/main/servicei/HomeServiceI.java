package com.cjc.main.servicei;

import com.cjc.main.model.Student;

public interface HomeServiceI {

	public void saveDate(Student s);

	public void logincheck(String un, String ps);

	public Iterable displayAllData();

}
