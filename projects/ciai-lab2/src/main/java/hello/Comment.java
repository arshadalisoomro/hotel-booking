package hello;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long comment_id;

	private String text;
	private Date comment_date;
	
	@ManyToOne
	private Hotel hotel;

	protected Comment() {}

	public Comment(long comment_id, String text, Date comment_date, Hotel hotel) {
		this.comment_id = comment_id;
		this.text = text;
		this.comment_date = comment_date;
		this.hotel = hotel;
	}

	public long getId() {
		return comment_id;
	}

	public void setId(long comment_id) {
		this.comment_id = comment_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCommentDate() {
		return comment_date;
	}

	public void setCommentDate(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
