package com.chandi.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Now let us define our main configuration for spring security -
 * SpringSecurityConfig.java.Here we have autowired our service class
 * UserDetailsService.java. which in turn will get the user details present in
 * the database.In the mean time, we have also made configuration to secure our
 * authentication process with CSRF attack.
 * 
 * This is the class which is reponsible to update the spring security context
 * with valid user and the corresponding role.
 * */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource(name = "userDetailService")
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/dashboard").hasRole("USER").and().formLogin().defaultSuccessUrl("/dashboard")
				.loginPage("/login").and().logout().permitAll();
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}
}