package booking.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserDetailsService customUserDetailsService;
	
	@Autowired
	public static PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder);		
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
		.defaultSuccessUrl("/signedin")	           
		.failureUrl("/users/login?error")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/");
		
		http.authorizeRequests();
		
//		http
//		.authorizeRequests()
//		
//		// Web admin
//		.antMatchers("/admin").hasAnyRole("ADMIN")
//		.antMatchers("/users").hasAnyRole("ADMIN")		
//		
//		// Comment moderator
//		.antMatchers("/comments/moderation").hasAnyRole("COMMENT_MODERATOR")
//		.antMatchers("/hotels/*/comments/*/approve").hasAnyRole("COMMENT_MODERATOR")
//		.antMatchers("/hotels/*/comments/*/remove").hasAnyRole("COMMENT_MODERATOR")
//			
//		// Hotel Manager
//		/* Filtrar bookings para so mostrar os do manager
//		   Falta adicionar resposta a comment */		 
//		.antMatchers("/bookings").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/bookings/*/approve").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/bookings/*/remove").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/new").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/rooms/*").hasRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/upload").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/edit").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/remove").hasAnyRole("ADMIN", "HOTEL_MANAGER")
//		.antMatchers("/hotels/*/remove_image/*").hasAnyRole("HOTEL_MANAGER")
//		
//		.antMatchers("/users/me").authenticated()
//		.anyRequest().permitAll();
	}	
}