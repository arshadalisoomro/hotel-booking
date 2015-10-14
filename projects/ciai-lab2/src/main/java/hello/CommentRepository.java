package hello;

import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	Comment findByText(String text);
}

