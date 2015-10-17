package hello;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int floor;	
	private String room_number;	
	
	@ManyToOne
	private RoomType type;
	
	@ManyToOne
	private Hotel hotel;
	
	@ElementCollection
	private Map<Date, Long> days_reserved = new HashMap<Date, Long>();
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private Map<Long, Booking> bookings = new HashMap<Long, Booking>();
	
	public Map<Long, Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Map<Long, Booking> bookings) {
		this.bookings = bookings;
	}

	protected Room() {}
	
	public Room (long id, int floor, String room_number, RoomType type, Hotel hotel) {
		this.id = id;
		this.floor = floor;
		this.room_number = room_number;	
		this.type = type;
		this.hotel = hotel;
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

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Map<Date, Long> getDays_reserved() {
		return days_reserved;
	}

	public void setDays_reserved(Map<Date, Long> days_reserved) {
		this.days_reserved = days_reserved;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
