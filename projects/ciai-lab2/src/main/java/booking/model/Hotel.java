package booking.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;    
    private String address;
    private int rating;
    
    @ManyToOne
    private Category category;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Map<Long, Room> rooms = new HashMap<Long, Room>();
 
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Map<Long, Comment> comments = new HashMap<Long, Comment>();
    
    public Hotel() {}
    
    public Hotel(long id, String name, String address, int rating, Category category) {    	
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.rating = rating;
    	this.category = category;    
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public Category getCategory(){
    	return category;
    }
    
    public void setCategory(Category category){
    	this.category = category;
    }
    
    public Map<Long, Room> getRooms() {
		return rooms;
	}

	public void setRooms(Map<Long, Room> rooms) {
		this.rooms = rooms;
	}
	
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	@Override
    public String toString() {
    	return "Id: " + getId() + "\nName: " + getName() + "\nAddress: " + getAddress() + "\nRating: " + getRating() + "\nCategory: " + category.getName() + "\n";
    }

}

