package br.com.igreja.mvc.cadastro1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	private UserDetails user;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("WebSecurityConfig");
		http.authorizeRequests().anyRequest().authenticated().and()
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())
				.logout(logout -> logout.logoutUrl("/logout")).csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("WebSecurityConfig2");
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);

	}

}
