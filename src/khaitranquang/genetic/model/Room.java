package khaitranquang.genetic.model;

public class Room {
	private String roomId;
	private String roomName;
	private	int seatingCapacity;
	
	public Room(String roomId, String roomName, int seatingCapacity) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.seatingCapacity = seatingCapacity;
	}
	
	public String getRoomId() {
		return roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
}
