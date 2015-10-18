package booking.repository;

import org.springframework.data.repository.CrudRepository;

import booking.model.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	Comment findByText(String text);
}

