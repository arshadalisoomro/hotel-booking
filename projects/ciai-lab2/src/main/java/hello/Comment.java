package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String text;
    
    protected Comment() {}
    
    public Comment(long id, String text) {
    	this.id = id;
    	this.text = text;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
