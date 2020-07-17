package com.user.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${security.username}")
	private String username;
	
	@Value("${security.password}")
	private String password;
	
	@Value("${security.role}")
	private String role;
	
	@Override
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
		  	auth
		  	// enable in memory based authentication with a user named
		  	// &quot;user&quot; and &quot;admin&quot;
		  	.inMemoryAuthentication().withUser(username).password(password).roles(role);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests().anyRequest().authenticated().and()
		.httpBasic().authenticationEntryPoint((request, response, exp) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED));
	}
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
