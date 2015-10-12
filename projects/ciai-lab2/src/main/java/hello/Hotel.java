package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;    
    private String address;
    private int rating;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
 
    protected Hotel() {}
    
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
    
    public String getCategory(){
    	return category.getName();
    }
    
    public void setCategory(Category category){
    	this.category = category;
    }
    
    @Override
    public String toString() {
    	return "Id: " + getId() + "\nName: " + getName();
    }

}

