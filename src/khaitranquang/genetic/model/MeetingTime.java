package khaitranquang.genetic.model;

public class MeetingTime {
	private String mtId;
	private String time;
	
	public MeetingTime(String mtId, String time) {
		this.mtId = mtId;
		this.time = time;
	}

	public String getMtId() {
		return mtId;
	}
	public String getTime() {
		return time;
	}
}
