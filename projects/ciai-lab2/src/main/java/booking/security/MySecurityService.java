package booking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import booking.model.CustomUserDetail;
import booking.model.Hotel;
import booking.repository.HotelRepository;

@Component("mySecurityService")
public class MySecurityService {

	@Autowired
	HotelRepository hotels;
	
	public boolean canEditHotel(long hotel_id, CustomUserDetail user){
		
		Hotel hotel = hotels.findOne(hotel_id);
		return hotel != null && hotel.getManager() != null && user.getUser().getId() == hotel.getManager().getId();
	}
}
