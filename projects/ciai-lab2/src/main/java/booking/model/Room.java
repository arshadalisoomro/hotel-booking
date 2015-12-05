package booking.model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Room implements Comparable<Object>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int floor;	
	private String room_number;	
	
	@JsonManagedReference
	@ManyToOne
	private RoomType type;
	
	@JsonManagedReference
	@ManyToOne
	private Hotel hotel;
	
	private int price;
	
	@ElementCollection
	private Map<Date, Long> days_reserved = new HashMap<Date, Long>();
	
	@JsonBackReference
	@ManyToMany(mappedBy="rooms")
	 private Set<Booking> bookings = new HashSet<Booking>();
	
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Room() {}
	
	public Room (long id, int floor, String room_number, RoomType type, Hotel hotel, int price) {
		this.floor = floor;
		this.id = id;
		this.room_number = room_number;	
		this.type = type;
		this.hotel = hotel;
		this.setPrice(price);
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Object o) {		
		return getRoom_number().compareTo(((Room) o).getRoom_number());
	}
}
