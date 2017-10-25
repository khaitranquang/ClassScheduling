package khaitranquang.genetic.model;
/* 
 * ClassByBit - Describe a period of Student.
 * Define a class by 9 bits
 * 		2 bits - index of room in ArrayList<Room>     - Data ( because data has 3 rooms)
 * 		3 bits - index of course in ArrayList<Course> - Data ( because data has 7 courses)
 * 		2 bits - index of instructors in ArrayList<Instructor> - Data ( because data has 4 instructors)
 * 		2 bits - index of meeting time in ArrayList<MeetingTime> - Data ( because data has 4  meeting times)
 */
public class ClassByBit {
	private String roomBit;
	private String courseBit;
	private String instructorBit;
	private String mtBit;
	
	private Data data;
	
	public ClassByBit(Data data) {
		initialize(data);
	}
	
	// Random all strings
	private ClassByBit initialize(Data data) {
		this.data = data;
		int sizeListRoom       = data.getListRoom().size();
		int sizeListCourse     = data.getListCourse().size();
		int sizeListInstructor = data.getListInstructor().size();
		int sizeListMT         = data.getListMT().size();
		
		this.roomBit = toBinaryStr((int) (sizeListRoom * Math.random()), 2);
		this.courseBit = toBinaryStr((int)(sizeListCourse * Math.random()), 3);
		this.instructorBit = toBinaryStr((int)(sizeListInstructor * Math.random()), 2);
		this.mtBit = toBinaryStr((int)(sizeListMT * Math.random()), 2);
		
		return this;
	}
	
	// to Binary String
	public String toBinaryStr(int n, int length) {
		String binaryStr = Integer.toBinaryString(n);
		if (binaryStr.length() < length) {
			int sub = length - binaryStr.length();
			//Add sub bit(s) 0
			for (int i = 0 ; i < sub; i++) {
				binaryStr = "0" + binaryStr;
			}
		}
		return binaryStr;
	}

	public String getRoomBit() {
		return roomBit;
	}
	public String getCourseBit() {
		return courseBit;
	}
	public String getInstructorBit() {
		return instructorBit;
	}
	public String getMtBit() {
		return mtBit;
	}
	public Data getData() {
		return data;
	}
	
	public void setRoomBit(String roomBit) {
		this.roomBit = roomBit;
	}
	public void setCourseBit(String courseBit) {
		this.courseBit = courseBit;
	}
	public void setInstructorBit(String instructorBit) {
		this.instructorBit = instructorBit;
	}
	public void setMtBit(String mtBit) {
		this.mtBit = mtBit;
	}

	@Override
	public String toString() {
		return roomBit + courseBit + instructorBit + mtBit;
	}
}
