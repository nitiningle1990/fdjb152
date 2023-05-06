 package com.cjc.main.serviceI;

import com.cjc.main.model.Student;

public interface HomeServiceI {

	public void saveData(Student s);

	public Iterable displayAllData();

	public Student logincheck(String username, String password);

	public void StudentData(int sid);

}
