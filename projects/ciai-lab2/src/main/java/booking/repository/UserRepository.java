package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByName(String name);
}

