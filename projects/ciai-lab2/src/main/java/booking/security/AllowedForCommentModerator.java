package booking.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize(AllowedForCommentModerator.condition)
public @interface AllowedForCommentModerator {
	String condition = "hasRole('ROLE_COMMENT_MODERATOR')";
}
