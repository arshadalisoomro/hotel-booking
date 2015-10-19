package booking.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
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
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="hotel", orphanRemoval = true)
    @MapKeyColumn(name="id")
    private Map<Long, Room> rooms = new HashMap<Long, Room>();
 
    @OneToMany(fetch = FetchType.EAGER, mappedBy="hotel", orphanRemoval = true)
    @MapKeyColumn(name="id")
    private Map<Long, Comment> comments = new HashMap<Long, Comment>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> images = new HashSet<String>();
    
    public Hotel() {}

	public Hotel(long id, String name, String address, int rating, Category category) {    	
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.rating = rating;
    	this.category = category;
    }

	public String getAddress() {
        return address;
    }
    
    public Category getCategory(){
    	return category;
    }

    public Map<Long, Comment> getComments() {
		return comments;
	}

    public long getId() {
        return id;
    }

    public Set<String> getImages() {
		return images;
	}

    public String getName() {
        return name;
    }
    
    public int getRating() {
        return rating;
    }

    public Map<Long, Room> getRooms() {
		return rooms;
	}
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategory(Category category){
    	this.category = category;
    }
    
    public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setImages(Set<String> images) {
		this.images = images;
	}

	public void setName(String name) {
        this.name = name;
    }
	
	public void setRating(int rating) {
        this.rating = rating;
    }

	public void setRooms(Map<Long, Room> rooms) {
		this.rooms = rooms;
	}

	@Override
    public String toString() {
    	return "Id: " + getId() + "\nName: " + getName() + "\nAddress: " + getAddress() + "\nRating: " + getRating() + "\nCategory: " + category.getName() + "\n";
    }

}

