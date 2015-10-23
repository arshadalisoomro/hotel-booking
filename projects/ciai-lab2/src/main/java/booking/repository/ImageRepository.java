package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Image;


public interface ImageRepository extends CrudRepository<Image, Long> {
	
}

