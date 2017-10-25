package khaitranquang.genetic.model;

import java.util.ArrayList;
import java.util.Arrays;


public class Data {
	private ArrayList<Room> listRoom;
	private ArrayList<Course> listCourse;
	private ArrayList<Instructor> listInstructor;
	private ArrayList<MeetingTime> listMT;
	private ArrayList<Department> listDept;
	
	private int numberOfClasses = 0;
	
	public Data() {
		initialize();
	}
	
	private Data initialize() {
		//Initialize rooms
		Room room0 = new Room("R0", "TC-410", 25);
		Room room1 = new Room("R1", "TC-411", 45);
		Room room2 = new Room("R2", "TC-412", 35);
		listRoom = new ArrayList<Room>(Arrays.asList(room0, room1, room2));
		
		//Initialize Meeting Times
		MeetingTime mt0 = new MeetingTime("MT0", "07:00 - 08:00");
		MeetingTime mt1 = new MeetingTime("MT1", "08:10 - 09:10");
		MeetingTime mt2 = new MeetingTime("MT2", "09:20 - 10:20");
		MeetingTime mt3 = new MeetingTime("MT3", "10:30 - 11:30");
		listMT = new ArrayList<MeetingTime>(Arrays.asList(mt0, mt1, mt2, mt3));
		
		//Initialize instructors
		Instructor instructor0 = new Instructor("I0", "Nguyen Nhat Quang");
		Instructor instructor1 = new Instructor("I1", "Nguyen Thi Oanh  ");
		Instructor instructor2 = new Instructor("I2", "Than Quang Khoat ");
		Instructor instructor3 = new Instructor("I3", "Ngo Van Linh     ");
		listInstructor = new ArrayList<Instructor>(Arrays.asList(instructor0, instructor1, instructor2, instructor3));
		
		//Initialize Courses
		Course course0 = new Course("IT0" , "Tri tue nhan tao", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor2)), 25);
		Course course1 = new Course("MA0" , "Giai tich I     ", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor1,instructor2)), 35);
		Course course2 = new Course("IT1" , "Co so du lieu   ", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor1)), 25);
		Course course3 = new Course("MA1" , "Dai so          ", new ArrayList<Instructor>(Arrays.asList(instructor2, instructor3)), 30);
		Course course4 = new Course("MA2" , "Toan roi rac    ", new ArrayList<Instructor>(Arrays.asList(instructor3)), 35);
		Course course5 = new Course("PH0" , "Nhiet hoc       ", new ArrayList<Instructor>(Arrays.asList(instructor0, instructor2)), 45);
		Course course6 = new Course("PH1" , "Quang hoc       ", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor3)), 45);
		listCourse = new ArrayList<Course>(Arrays.asList(course0, course1, course2, course3, course4, course5, course6));
		
		//Initialize Department
		Department dept0 = new Department("IT" , new ArrayList<Course>(Arrays.asList(course0, course2)));
		Department dept1 = new Department("MA" , new ArrayList<Course>(Arrays.asList(course1, course3, course4)));
		Department dept2 = new Department("PH" , new ArrayList<Course>(Arrays.asList(course5, course6)));
		listDept = new ArrayList<Department>(Arrays.asList(dept0, dept1, dept2));
		
		//Number of classes
		listDept.forEach(i -> numberOfClasses += i.getListCourse().size());
		
		return this;
	}

	public ArrayList<Room> getListRoom() {
		return listRoom;
	}
	public ArrayList<Course> getListCourse() {
		return listCourse;
	}
	public ArrayList<Instructor> getListInstructor() {
		return listInstructor;
	}
	public ArrayList<MeetingTime> getListMT() {
		return listMT;
	}
	public ArrayList<Department> getListDept() {
		return listDept;
	}
	public int getNumberOfClasses() {
		return numberOfClasses;
	}
}
