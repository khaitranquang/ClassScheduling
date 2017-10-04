package khaitranquang.genetic.models;

import java.util.ArrayList;

public class CourseGA {
	private String id = null;	//ID of this course
	private String name = null;
	private int maxNumbOfStudents;
	private ArrayList<InstructorGA> instructorsGA;
	private DepartmentGA departmentGA;
	
	// Constructor
	public CourseGA (String id, String name, DepartmentGA departmentGA, ArrayList<InstructorGA> instructorsGA, int maxNumbOfStudents) {
		this.id = id;
		this.name = name;
		this.departmentGA = departmentGA;
		this.instructorsGA = instructorsGA;
		this.maxNumbOfStudents = maxNumbOfStudents;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMaxNumbOfStudents() {
		return maxNumbOfStudents;
	}

	public ArrayList<InstructorGA> getInstructorsGA() {
		return instructorsGA;
	}

	public DepartmentGA getDepartmentGA() {
		return departmentGA;
	}
	
	public String toString(){	//toString() return name of Course
		return name;
	} 
}
