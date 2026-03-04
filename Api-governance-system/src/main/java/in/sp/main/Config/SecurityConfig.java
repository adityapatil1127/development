package in.sp.main.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.sp.main.security.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.csrf(csrf -> csrf.disable())
		
		.authorizeHttpRequests(auth -> auth
		        .requestMatchers("/auth/**").permitAll()
		        .requestMatchers("/admin/api/**").hasRole("ADMIN")
		        .requestMatchers("/admin/**").hasRole("ADMIN")
		        .requestMatchers("/manager/**").hasRole("MANAGER")
		        .requestMatchers("/dev/**").hasRole("DEV")
		        .requestMatchers("/usage/**").authenticated()
		        .anyRequest().authenticated()
		)
		
		.sessionManagement(session ->
		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		)
	
		.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
		
	}
	
}
