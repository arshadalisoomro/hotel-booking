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
	private Date date;

	protected Comment() {}

	public Comment(long comment_id, String text, Date date) {
		this.comment_id = comment_id;
		this.text = text;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
