package booking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String text;
	private Date date;
	private boolean status;
	private boolean isAnswer;
	
	@OneToOne
	private Comment reply;
		
	@JsonBackReference
	@ManyToOne
	private Hotel hotel;
	
	@JsonBackReference
	@ManyToOne
	private User user;

	public Comment() {}

	public Comment(String text, Date date, User user, boolean status, Hotel hotel) {
		this.text = text;
		this.date = date;
		this.user = user;
		this.status = status;
		this.hotel = hotel;
		this.isAnswer = false;
	}

	public Comment getReply() {
		return reply;
	}

	public void setReply(Comment reply) {
		this.reply = reply;
	}

	public Date getDate() {
		return date;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public long getId() {
		return id;
	}

	public boolean getStatus() {
		return status;
	}

	public String getText() {
		return text;
	}

	public User getUser() {
		return user;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean getIsAnswer() {
		return isAnswer;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

}
