package ca.sheridancollege.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
		throws Exception {
		
		auth.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("Daniel").password("1390").roles("USER")		// 3 roles USER,STAFF,ADMIN
		.and()
		.withUser("Ernesto").password("1390").roles("ADMIN")
		.and()
		.withUser("Ximena").password("1390").roles("STAFF");
	}

}
