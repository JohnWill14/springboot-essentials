package br.com.william.spring_essentials.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.william.spring_essentials.service.CustomUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private  CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		super();
		this.customUserDetailsService = customUserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
//		try {
//			authenticationManagerBuilder.inMemoryAuthentication().withUser("John William").password("qwe123")
//					.roles("USER", "ADM").and().withUser("JADEN YUGI").password("slave").roles("USER");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
