package com.bbx2.ikeagoconlibros;



import com.bbx2.ikeagoconlibros.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class IkeagoconlibrosApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(IkeagoconlibrosApplication.class, args);
	}

//	@EnableWebSecurity
//	@Configuration
//	class WebSecurityConfig extends WebSecurityConfigurerAdapter
//	{
//		@Override
//		protected void configure(HttpSecurity http) throws Exception{
//			http.csrf().disable()
//					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//					.authorizeRequests()
//					//.antMatchers(HttpMethod.POST,"/user").permitAll()
//					.antMatchers("*","/*","*/*","/*/*").permitAll()
//					.anyRequest().authenticated();
//		}
//	}

}

