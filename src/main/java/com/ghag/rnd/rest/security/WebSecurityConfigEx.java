package com.ghag.rnd.rest.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

//@Configuration
//@EnableWebMvcSecurity
public class WebSecurityConfigEx extends WebSecurityConfigurerAdapter 
{
	
	@Autowired
    private DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic()
                .and()
            .csrf()
            	.disable()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       
//    	auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
       
    	
    	auth.jdbcAuthentication()
		 .dataSource(dataSource)
		 .withUser("user").password("password").roles("USER").and()
		 .withUser("ganesh").password("password").roles("USER").and()
		 .withUser("prachi").password("password").roles("USER").and()
		 .withUser("janhavi").password("password").roles("USER");
    }
}
