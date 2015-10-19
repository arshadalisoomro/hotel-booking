package booking.model;

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
	private long id;

	private String text;
	private Date date;
	private boolean status;
	
//	@ManyToOne
//	private Comment commentParent;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy="commentParent", orphanRemoval = true)
//    @MapKeyColumn(name="id")
//    private Map<Long, Comment> replies = new HashMap<Long, Comment>();
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToOne
	private User user;

	public Comment() {}

	public Comment(long id, String text, Date date, User user, boolean status, Hotel hotel) {
		this.id = id;
		this.text = text;
		this.date = date;
		this.user = user;
		this.status = status;
		this.hotel = hotel;
	}
	
//	public Comment getCommentParent() {
//		return commentParent;
//	}

	public Date getDate() {
		return date;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public long getId() {
		return id;
	}

//	public Map<Long, Comment> getReplies() {
//		return replies;
//	}

	public boolean getStatus() {
		return status;
	}

	public String getText() {
		return text;
	}

	public User getUser() {
		return user;
	}

//	public void setCommentParent(Comment commentParent) {
//		this.commentParent = commentParent;
//	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void setId(long id) {
		this.id = id;
	}
	
//	public void setReplies(Map<Long, Comment> replies) {
//		this.replies = replies;
//	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
