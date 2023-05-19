package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() {

		// User Role
		UserDetails theUser = User.withUsername("amit")
				.passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
				.password("amit").roles("USER").build();
		UserDetails theUser2 = User.withUsername("dkd")
				.passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
				.password("dkd").roles("ADMIN","USER").build();

//		// Manager Role
//		UserDetails theManager = User.withUsername("john")
//				.passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
//				.password("87654321").roles("MANAGER").build();

		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

		userDetailsManager.createUser(theUser);
		userDetailsManager.createUser(theUser2);
//		userDetailsManager.createUser(theManager);

		return userDetailsManager;
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//			http
//				.csrf()
//				.disable()
//				.authorizeHttpRequests()
//				.requestMatchers("/managers/status/check")
//				.hasAnyAuthority("DELETE_USER_AUTHORITY")
//				.requestMatchers("/users/status/check")
//				.hasRole("USER")
//				.anyRequest()
//				.authenticated()
//				.and()
//				.httpBasic()
//				.and()
//				.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.csrf().
		disable()
		.authorizeHttpRequests()
		.requestMatchers("/user")
		.hasRole("USER")
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/admin")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
}