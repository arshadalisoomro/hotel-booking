package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Category findByName(String name);
}

