package booking.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password("pass").roles("USER").and()
		.withUser("admin").password("pass").roles("USER", "ADMIN");	
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
	        .authorizeRequests()	        	
	        	.antMatchers("/", "/hotels", "/hotels/*", "/users/new").permitAll()	        	
	        	.anyRequest().authenticated()
	        	.and()
	        .formLogin()
	            .loginPage("/")
	            .defaultSuccessUrl("/")	           
	            .failureUrl("/")
	            .permitAll()
	            .and()
	        .logout()
	        	.logoutSuccessUrl("/hotels")
	        	.permitAll();        
	}	
}