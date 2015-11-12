package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Authority;


public interface AuthorityRepository extends CrudRepository<Authority, Long> {
	
	Authority findByRole(String role);
}

