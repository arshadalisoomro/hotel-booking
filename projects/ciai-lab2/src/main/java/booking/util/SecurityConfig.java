package booking.util;

import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
	DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, true from user where username=?")
		.authoritiesByUsernameQuery("select username, role from authority where username=?");
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
	            .failureUrl("/?error")
	            .permitAll()
	            .and()
	        .logout()
	        	.logoutSuccessUrl("/")
	        	.permitAll();        
	}	
}