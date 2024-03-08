package com.example.trupper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityChainFilter(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf( csrf -> csrf.disable() )
				.headers().disable()
				.authorizeRequests( auth -> auth.anyRequest().permitAll() )
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		var adminUser = User.withUsername("superadmin")
				.password(passwordEncoder().encode("secure_password_1234"))
				.authorities("read", "write")
				.build();
		
		var result = new InMemoryUserDetailsManager();
		result.createUser(adminUser);
		
		return result;
	}
	
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
