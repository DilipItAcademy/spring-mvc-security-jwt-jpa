package com.zomato.secuirty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

	// Few PreDefined Beans i have to Define

	@Autowired
	JWTTokenAuthenticationFilter jwtTokenAuthenticationFilter;

	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	// Passwords should be encoded/encrypted always
	@Bean
	BCryptPasswordEncoder geBbCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

		System.out.println("This securityFilter method of ruless ");
		
		security.csrf().disable()
				.authorizeHttpRequests().antMatchers("/create/user", "/login/user").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilterBefore(this.jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return security.build();

	}

}
