package khaitranquang.genetic;

import java.util.ArrayList;
import java.util.Arrays;

import khaitranquang.genetic.domain.Course;
import khaitranquang.genetic.domain.Department;
import khaitranquang.genetic.domain.Instructor;
import khaitranquang.genetic.domain.MeetingTime;
import khaitranquang.genetic.domain.Room;

public class Data {
	private ArrayList<Room> rooms;
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;
	private ArrayList<Department> depts;
	private ArrayList<MeetingTime> meetingTimes;

	private int numberOfClasses = 0;

	public Data() {
		initialize();
	}

	// Khoi tao database (Sau co the nang cap dung database)
	private Data initialize(){
		//Initialize rooms
		Room room1 = new Room("R1", 25);
		Room room2 = new Room("R2", 45);
		Room room3 = new Room("R3", 35);
		rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3));
		
		//Initialize meeting times
		MeetingTime meetingTime1 = new MeetingTime("MT1", "MWF 09:00 - 10:00");
		MeetingTime meetingTime2 = new MeetingTime("MT2", "MWF 10:00 - 11:00");
		MeetingTime meetingTime3 = new MeetingTime("MT3", "TTH 09:00 - 10:30");
		MeetingTime meetingTime4 = new MeetingTime("MT4", "TTH 10:30 - 12:00");
		meetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));
		
		//Initialize instructor
		Instructor instructor1 = new Instructor("I1", "Dr James Web  ");
		Instructor instructor2 = new Instructor("I2", "Mr. Mike Brown");
		Instructor instructor3 = new Instructor("I3", "Dr Steve Day  ");
		Instructor instructor4 = new Instructor("I4", "Mrs Jan Doe   ");
		instructors = new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2, instructor3, instructor4));
		
		//Initialize courses
		Course course1 = new Course("C1", "325K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2)), 25);
		Course course2 = new Course("C2", "319K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2, instructor3)), 35);
		Course course3 = new Course("C3", "462K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2)), 25);
		Course course4 = new Course("C4", "464K", new ArrayList<Instructor>(Arrays.asList(instructor3, instructor4)), 30);
		Course course5 = new Course("C5", "360C", new ArrayList<Instructor>(Arrays.asList(instructor4)), 35);
		Course course6 = new Course("C6", "303K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor3)), 45);
		Course course7 = new Course("C7", "303L", new ArrayList<Instructor>(Arrays.asList(instructor2, instructor4)), 45);
		courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));
		
		//Initialize Department	- Nganh - Bomon
		Department dept1 = new Department("Math", new ArrayList<Course>(Arrays.asList(course1, course3)));
		Department dept2 = new Department("EE"  , new ArrayList<Course>(Arrays.asList(course2, course4, course5)));
		Department dept3 = new Department("PHY" , new ArrayList<Course>(Arrays.asList(course6, course7)));
		depts = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
		// Number of courses
		depts.forEach(i -> numberOfClasses += i.getCourses().size());
		
		return this;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public ArrayList<Department> getDepts() {
		return depts;
	}

	public ArrayList<MeetingTime> getMeetingTimes() {
		return meetingTimes;
	}

	public int getNumberOfClasses() {
		return this.numberOfClasses;
	}
}
