package khaitranquang.genetic.domain;

public class MeetingTime {
	private String id;
	private String time;
	
	public MeetingTime (String id, String time) {
		this.id = id;
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTime() {
		return time;
	}
	
}
