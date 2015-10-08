package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


public interface HotelRepository extends CrudRepository<Hotel, Long> {
	
	@Query("select * from hotel join address")
	public List<Hotel> findAllWithAddress();

	Hotel findByName(String name);
}

