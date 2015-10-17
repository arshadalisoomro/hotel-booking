package hello;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date begin_date, end_date;
	private boolean state;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Room room;
	
	protected Booking(){}
	
	public Booking(long id, Date begin_date, Date end_date, boolean state, User user, Room room){
		this.id = id;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.user = user;
		this.state = state;
		this.room = room;
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
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
