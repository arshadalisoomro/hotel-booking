package booking.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", orphanRemoval = true)
	@MapKeyColumn(name="id")
    private Map<Long, Comment> comments = new HashMap<Long, Comment>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="manager", orphanRemoval = true)
	private Set<Hotel> hotels = new HashSet<Hotel>();
	
	private String role;

	public User() {}

	public User(long id, String name, String username, String password, String email, String role) {
		this.name = name;
		this.id = id;
		this.username = username;
		this.setPassword(password);
		this.setEmail(email);
		this.role = role;
	}
	
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public String getEmail() {
		return email;
	}
	
	public Set<Hotel> getHotels() {
		return hotels;
	}
	
	public long getId() {
        return id;
    }

    public String getName() {
		return name;
	}

    public String getPassword() {
		return password;
	}

    public String getRole() {
		return role;
	}

	public String getUsername() {
        return username;
    }

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	public void setId(long id) {
        this.id = id;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
        this.username = username;
    }

}
