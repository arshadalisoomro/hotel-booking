package booking.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize(AllowedForRemovingBookings.condition)
public @interface AllowedForRemovingBookings {
	String condition = "@mySecurityService.canRemoveBooking(#booking_id, principal)";

}
