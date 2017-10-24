package khaitranquang.genetic.model;

import java.util.ArrayList;

public class Course {
	private String courseId;
	private String courseName;
	private ArrayList<Instructor> listInstructor;
	private int maxNumbOfStudents;
	
	public Course(String courseId, String courseName, ArrayList<Instructor> listInstructor, int maxNumbOfStudents) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.listInstructor = listInstructor;
		this.maxNumbOfStudents = maxNumbOfStudents;
	}

	public String getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public ArrayList<Instructor> getListInstructor() {
		return listInstructor;
	}
	public int getMaxNumbOfStudents() {
		return maxNumbOfStudents;
	}
	
	@Override
	public String toString() {
		return courseName;
	}
}
