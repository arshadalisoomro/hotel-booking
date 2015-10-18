package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Booking;


public interface BookingRepository extends CrudRepository<Booking, Long> {
	
}

