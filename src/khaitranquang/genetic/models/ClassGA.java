package khaitranquang.genetic.models;

/*
 * ClassGA - Describe a period of Student.
 * Convert to a binary string (12 bits)
 * 		3 bits - number of class (1 -> 7)
 * 		2 bits - index of room in ArrayList<RoomGA>   - Data ( because data has 3 rooms)
 * 		3 bits - index of room in ArrayList<CourseGA> - Data ( because data has 7 courses)
 * 		2 bits - index of instructors in ArrayList<InstructorGA> - Data ( because data has 4 instructors)
 * 		2 bits - index of meeting time in ArrayList<MeetingTimeGA> - Data ( because data has 4  meeting times)
 */
public class ClassGA {
	private int indexOfClass;
	private int indexOfRoom;
	private int indexOfCourse;
	private int indexOfInstructor;
	private int indexOfMeetingTime;
	
	// Constructors
	public ClassGA(int indexOfClass, int indexOfRoom, int indexOfCourse, int indexOfInstructor,
			int indexOfMeetingTime) {
		this.indexOfClass = indexOfClass;
		this.indexOfRoom = indexOfRoom;
		this.indexOfCourse = indexOfCourse;
		this.indexOfInstructor = indexOfInstructor;
		this.indexOfMeetingTime = indexOfMeetingTime;
	}
	
	// toString
	@Override
	public String toString() {
		return Integer.toBinaryString(indexOfClass) + Integer.toBinaryString(indexOfRoom) +
			   Integer.toBinaryString(indexOfCourse) + Integer.toBinaryString(indexOfInstructor) +
			   Integer.toBinaryString(indexOfMeetingTime);
	}
	
	public String getIndexClassBinary () {
		return Integer.toBinaryString(indexOfClass);
	}
	public String getIndexRoomBinary () {
		return Integer.toBinaryString(indexOfRoom);
	}
	public String getIndexCourseBinary () {
		return Integer.toBinaryString(indexOfCourse);
	}
	public String getIndexInstructorBinary () {
		return Integer.toBinaryString(indexOfInstructor);
	}
	public String getIndexMeetingTimeBinary () {
		return Integer.toBinaryString(indexOfMeetingTime);
	}
	
}
