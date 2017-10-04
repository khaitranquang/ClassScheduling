package khaitranquang.genetic.models;

public class DepartmentGA {
	private String deptID;
	private String name;
	
	public DepartmentGA(String deptID, String name) {
		this.deptID = deptID;
		this.name = name;
	}

	public String getDeptID() {
		return deptID;
	}

	public String getName() {
		return name;
	}
}
