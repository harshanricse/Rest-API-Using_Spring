package com.infytel.config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfiguration extends WebSecurityConfiguration
{
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	public void configureCredentials(@Lazy AuthenticationManagerBuilder auth) 
			throws Exception
	{
	auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder
			.encode("infytel")).authorities("ROLE_ADMIN");

	}
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()

        .anyRequest().authenticated()
        .and(). 
        httpBasic().and()
       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
       .and().csrf().disable();
		
	return http.build();
	}
  
	
}




