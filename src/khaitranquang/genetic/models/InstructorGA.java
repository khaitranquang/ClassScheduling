package khaitranquang.genetic.models;

public class InstructorGA {
	private String instructorID;
	private String name;
	
	public InstructorGA(String instructorID, String name) {
		this.instructorID = instructorID;
		this.name = name;
	}
	
	public String getId() {
		return instructorID;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {	//Method toString will return name
		return name;
	}
}
