package booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long category_id;
	
	private String name;
	
	public Category(){}
	
	public Category(long id, String name){
		this.category_id = id;
		this.name = name;	
	}

	public long getId(){
		return category_id;
	}
	
	public void setId(long id){
		this.category_id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString() {
		return name;
	}
}
