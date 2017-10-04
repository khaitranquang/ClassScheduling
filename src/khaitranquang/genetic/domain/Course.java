package khaitranquang.genetic.domain;

import java.util.ArrayList;

public class Course {
	private String number = null;		//Number ID of course
	private String name = null;			//Name of course
	private int maxNumbOfStudents;
	private ArrayList<Instructor> instructors;	// Instructors teaches this course.
	
	public Course(String number, String name, ArrayList<Instructor> instructor, int maxNumbOfStudents) {
		this.number = number;
		this.name = name;
		this.instructors = instructor;
		this.maxNumbOfStudents = maxNumbOfStudents;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}

	public int getMaxNumbOfStudents() {
		return maxNumbOfStudents;
	}


	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	public String toString(){	//toString() return name of Course
		return name;
	}

}
