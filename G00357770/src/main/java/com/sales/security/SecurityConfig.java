package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		//pages that require login
		httpSecurity.authorizeRequests().antMatchers("/addProducts.html","/addCustomer.html", "/addOrder.html")
		.hasRole("USER").and().formLogin().and()
	    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    .logoutSuccessUrl("/index.html");
	  }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)

			throws Exception {
		// User name & Password to Log in are ("user") and ("user")
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
}