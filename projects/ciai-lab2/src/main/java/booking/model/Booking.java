package booking.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date begin_date, end_date;
	private boolean state;
	
	@ManyToOne
	private User user;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Room> rooms = new HashSet<Room>();
	
	public Booking(){}
	
	public Booking(long id, Date begin_date, Date end_date, boolean state, User user){
		this.id = id;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.user = user;
		this.state = state;
	}
	
	public Hotel getHotel()
	{
		return rooms.iterator().next().getHotel();
	}
	
	public String getRoomType()
	{
		return rooms.iterator().next().getType().toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
}
