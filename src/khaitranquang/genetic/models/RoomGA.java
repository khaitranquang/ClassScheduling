package khaitranquang.genetic.models;

public class RoomGA {
	private String roomID;
	private String name;
	private int seatingCapacity;
	
	public RoomGA (String roomID, String name, int seatingCapacity){
		this.roomID = roomID;
		this.name = name;
		this.seatingCapacity = seatingCapacity;
	}
	
	public String getRoomID() {
		return roomID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSeatingCapacity () {
		return seatingCapacity;
	}
}
