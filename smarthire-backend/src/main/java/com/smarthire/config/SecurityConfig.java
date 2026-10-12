package com.smarthire.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.smarthire.security.CustomUserDetailsService;
import com.smarthire.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	private final CustomUserDetailsService customUserDetailsService;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	public SecurityConfig(CustomUserDetailsService customUserDetailsService,
			JwtAuthenticationFilter jwtAuthenticationFilter) {

		this.customUserDetailsService = customUserDetailsService;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilterRegistration(
	        JwtAuthenticationFilter filter) {

	    FilterRegistrationBean<JwtAuthenticationFilter> registration =
	            new FilterRegistrationBean<>(filter);

	    registration.setEnabled(false);
	    return registration;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth

						// Registration aur login sabke liye public hain
						.requestMatchers("/api/auth/**").permitAll()

						// Job dekhne aur search karne ki permission
						.requestMatchers(org.springframework.http.HttpMethod.GET, "/api/jobs", "/api/jobs/search",
								"/api/jobs/search/location", "/api/jobs/*")
						.hasAnyRole("CANDIDATE", "RECRUITER", "ADMIN")

						// Job create, update aur delete karne ki permission
						.requestMatchers(org.springframework.http.HttpMethod.POST, "/api/jobs")
						.hasAnyRole("RECRUITER", "ADMIN")

						.requestMatchers(org.springframework.http.HttpMethod.PUT, "/api/jobs/*")
						.hasAnyRole("RECRUITER", "ADMIN")

						.requestMatchers(org.springframework.http.HttpMethod.DELETE, "/api/jobs/*")
						.hasAnyRole("RECRUITER", "ADMIN")

						// Baaki protected APIs ke liye login required hai
						.anyRequest().authenticated())
				//.httpBasic(Customizer.withDefaults())
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	
	
	

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

		return configuration.getAuthenticationManager();
	}
}
