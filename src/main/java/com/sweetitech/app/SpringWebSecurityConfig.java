package com.sweetitech.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/").hasRole("ADMIN")

				.and().authorizeRequests().antMatchers(HttpMethod.GET, "/all_countries").hasRole("ADMIN").and()
				.authorizeRequests().antMatchers(HttpMethod.GET, "/delete/**").hasRole("ADMIN").and()
				.authorizeRequests().antMatchers(HttpMethod.POST, "/update").hasRole("ADMIN")

				.and().authorizeRequests().antMatchers(HttpMethod.POST, "/team/upload").hasRole("ADMIN")

				.and().authorizeRequests().antMatchers(HttpMethod.POST, "/team/upload/**").hasRole("ADMIN")

				.and().authorizeRequests().antMatchers(HttpMethod.POST, "/team//members/country/**").hasRole("ADMIN")
				.and().authorizeRequests().antMatchers(HttpMethod.GET, "/team/previous/**").hasRole("ADMIN")

				.and().authorizeRequests().antMatchers(HttpMethod.GET, "/team/delete/**").hasRole("ADMIN")

				.and().authorizeRequests().antMatchers(HttpMethod.POST, "/upload").hasRole("ADMIN").and().csrf()
				.disable().formLogin().disable();
	}
}
