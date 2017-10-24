package khaitranquang.genetic.model;

import java.util.ArrayList;

public class Department {
	private String deptName;
	private ArrayList<Course> listCourse;
	
	public Department(String deptName, ArrayList<Course> listCourse) {
		this.deptName = deptName;
		this.listCourse = listCourse;
	}

	public String getDeptName() {
		return deptName;
	}
	public ArrayList<Course> getListCourse() {
		return listCourse;
	}
}
