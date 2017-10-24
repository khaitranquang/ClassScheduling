package khaitranquang.genetic.model;

public class Instructor {
	private String instructorId;
	private String instructorName;
	
	public Instructor(String instructorId, String instructorName) {
		this.instructorId = instructorId;
		this.instructorName = instructorName;
	}

	public String getInstructorId() {
		return instructorId;
	}
	public String getInstructorName() {
		return instructorName;
	}	
}
