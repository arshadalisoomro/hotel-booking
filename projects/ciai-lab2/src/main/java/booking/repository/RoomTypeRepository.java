package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.RoomType;


public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
	
	
}

