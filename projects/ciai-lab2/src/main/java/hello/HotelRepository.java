package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


public interface HotelRepository extends CrudRepository<Hotel, Long> {
	
	Hotel findByName(String name);
}

