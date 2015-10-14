package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int floor;	
	private String room_number;	
	
	/* 
	 * Falta adicionar o tipo
	 * @onetomany(mappedby="type")
     * private roomtype type;
	 * 
	 * 
	 */
	
	protected Room() {}
	
	public Room (long id, int floor, String room_number) {
		this.id = id;
		this.floor = floor;
		this.room_number = room_number;	
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	
	
	
}
