package booking.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import booking.repository.UserRepository;
import booking.util.UserNotFoundException;

@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String name) throws UserNotFoundException{
        // returns the get(0) of the user list obtained from the db
        User domainUser = userRepository.findByUsername(name);
        String role = domainUser.getAuthority().getRole();
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        authorities.add(new SimpleGrantedAuthority(role));

        CustomUserDetail customUserDetail=new CustomUserDetail();
        customUserDetail.setUser(domainUser);
        customUserDetail.setAuthorities(authorities);
        return customUserDetail;

    }

}
