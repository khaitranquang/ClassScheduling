package khaitranquang.genetic.domain;

public class Instructor {
	private String id;
	private String name;
	
	public Instructor(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {	//Method toString will return name
		return name;
	}
}
