package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Room;


public interface RoomRepository extends CrudRepository<Room, Long> {
	
	
}

