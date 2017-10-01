package khaitranquang.genetic.domain;

public class Room {
	private String number;
	private int seatingCapacity;	//So cho toi da cua lop
	
	public Room (String number, int seatingCapacity) {
		this.number = number;
		this.seatingCapacity = seatingCapacity;
	}
	
	public String getNumber() {
		return number;
	}
	
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
}
