package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
	
	
}

