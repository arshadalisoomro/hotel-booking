package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Hotel;


public interface HotelRepository extends CrudRepository<Hotel, Long> {
	
	Hotel findByName(String name);
}

