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

//		auth.inMemoryAuthentication()
//			.withUser("admin").password("pass").roles("USER", "ADMIN").and()
//			.withUser("user").password("pass").roles("USER");
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
		.failureUrl("/?error")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.permitAll();
		
		http
		.authorizeRequests()
		.antMatchers("/bookings").hasAnyRole("ADMIN")
		.antMatchers("/hotels/new").hasAnyRole("ADMIN")
		.antMatchers("/hotels/*/upload").hasAnyRole("ADMIN")
		.antMatchers("/hotels/*/edit").hasAnyRole("ADMIN")
		.antMatchers("/hotels/*/remove").hasAnyRole("ADMIN")
		.antMatchers("/hotels/*/comments/*/approve").hasAnyRole("ADMIN")
		.antMatchers("/hotels/*/remove_image/*").hasAnyRole("ADMIN")		
		.anyRequest().permitAll();
	}	
}