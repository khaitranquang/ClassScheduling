package khaitranquang.genetic.models;

import java.util.ArrayList;
import java.util.Arrays;

public class DataCS {
	private ArrayList<RoomGA> rooms;
	private ArrayList<CourseGA> courses;
	private ArrayList<InstructorGA> instructors;
	private ArrayList<DepartmentGA> depts;
	private ArrayList<MeetingTimeGA> meetingTimes;
	
	private int numberOfClass = 0;
	
	public DataCS() {
		initialize();
	}
	
	private DataCS initialize() {
		//Initialize rooms
		RoomGA room0 = new RoomGA("R0", "TC-400", 25);
		RoomGA room1 = new RoomGA("R1", "TC-401", 45);
		RoomGA room2 = new RoomGA("R2", "TC-402", 35);
		rooms = new ArrayList<RoomGA>(Arrays.asList(room0, room1, room2));
		
		//Initialize Departments
		DepartmentGA department0 = new DepartmentGA("IT", "Cong nghe tong tin");
		DepartmentGA department1 = new DepartmentGA("MA", "Vien Toan");
		DepartmentGA department2 = new DepartmentGA("PHY", "Vien Vat ly");
		depts = new ArrayList<DepartmentGA>(Arrays.asList(department0, department1, department2));
		
		//Initialize Instructors
		InstructorGA instructor0 = new InstructorGA("I0", "Nguyen Nhat Quang");
		InstructorGA instructor1 = new InstructorGA("I1", "Nguyen Thi Oanh  ");
		InstructorGA instructor2 = new InstructorGA("I2", "Than Quang Khoat ");
		InstructorGA instructor3 = new InstructorGA("I3", "Ngo Van Linh     ");
		instructors = new ArrayList<InstructorGA>(Arrays.asList(instructor0, instructor1, instructor2, instructor3));
		
		//Initialize Courses
		CourseGA course0 = new CourseGA("IT0", "Tri tue nhan tao", department0, new ArrayList<InstructorGA>(Arrays.asList(instructor0, instructor2)), 25);
		CourseGA course1 = new CourseGA("MA0", "Giai tich I", department1, new ArrayList<InstructorGA>(Arrays.asList(instructor0, instructor1,instructor2)), 35);
		CourseGA course2 = new CourseGA("IT1", "Co so du lieu", department0, new ArrayList<InstructorGA>(Arrays.asList(instructor0, instructor1)), 25);
		CourseGA course3 = new CourseGA("MA1", "Dai so", department1, new ArrayList<InstructorGA>(Arrays.asList(instructor2, instructor3)), 30);
		CourseGA course4 = new CourseGA("MA2", "Toan roi rac", department1, new ArrayList<InstructorGA>(Arrays.asList(instructor3)), 35);
		CourseGA course5 = new CourseGA("PHY0", "Nhiet hoc", department2, new ArrayList<InstructorGA>(Arrays.asList(instructor0, instructor2)), 45);
		CourseGA course6 = new CourseGA("PHY1", "Quang hoc", department2, new ArrayList<InstructorGA>(Arrays.asList(instructor1, instructor3)), 45);
		courses = new ArrayList<CourseGA>(Arrays.asList(course0, course1, course2, course3, course4, course5, course6));
		
		//Initialize Meeting Times
		MeetingTimeGA meetingTime1 = new MeetingTimeGA("MT1", "MWF 09:00 - 10:00");
		MeetingTimeGA meetingTime2 = new MeetingTimeGA("MT2", "MWF 10:00 - 11:00");
		MeetingTimeGA meetingTime3 = new MeetingTimeGA("MT3", "TTH 09:00 - 10:30");
		MeetingTimeGA meetingTime4 = new MeetingTimeGA("MT4", "TTH 10:30 - 12:00");
		meetingTimes = new ArrayList<MeetingTimeGA>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));
		
		// Number of class
		numberOfClass = courses.size();
		
		return this;
	}

	public int getNumberOfClass() {
		return this.numberOfClass;
	}

//	public void setNumberOfClass(int numberOfClass) {
//		this.numberOfClass = numberOfClass;
//	}

	public ArrayList<RoomGA> getRooms() {
		return rooms;
	}

	public ArrayList<CourseGA> getCourses() {
		return courses;
	}

	public ArrayList<InstructorGA> getInstructors() {
		return instructors;
	}

	public ArrayList<DepartmentGA> getDepartments() {
		return depts;
	}

	public ArrayList<MeetingTimeGA> getMeetingTimes() {
		return meetingTimes;
	}
	
	
}
