package booking.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserDetailsService customUserDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder);
		auth.userDetailsService(customUserDetailsService);
		
	}

	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/static/**")
		.antMatchers("/js/**")
		.antMatchers("/css/**");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
		.loginPage("/")
		.defaultSuccessUrl("/")	           
		.failureUrl("/users/login?error")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.permitAll();
		
		http
		.authorizeRequests().
		anyRequest().permitAll() // remove this line to activate security again
		.antMatchers("/bookings").hasAnyRole("ADMIN")
		.antMatchers("/hotels/new").hasAnyRole("ADMIN", "HOTEL_MANAGER")
		.antMatchers("/hotels/*/upload").hasAnyRole("ADMIN", "HOTEL_MANAGER")
		.antMatchers("/hotels/*/edit").hasAnyRole("ADMIN", "HOTEL_MANAGER")
		.antMatchers("/hotels/*/remove").hasAnyRole("ADMIN", "HOTEL_MANAGER")
		.antMatchers("/hotels/*/comments/*/approve").hasAnyRole("ADMIN", "COMMENT_MODERATOR")
		.antMatchers("/hotels/*/comments/*/remove").hasAnyRole("ADMIN", "COMMENT_MODERATOR")
		.antMatchers("/hotels/*/remove_image/*").hasAnyRole("ADMIN", "HOTEL_MANAGER")		
		.anyRequest().permitAll();
	}	
}