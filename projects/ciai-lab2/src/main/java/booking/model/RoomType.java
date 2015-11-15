package booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String description;
	private int occupancy;
	
	protected RoomType() {}
	
	public RoomType(String description, int occupancy) {
		this.description = description;
		this.occupancy = occupancy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	
}
