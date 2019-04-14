package es.cjolalla.catalogingredients.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan("es.cjolalla.catalogingredients.security")
public class SecurityCatalogConfig extends WebSecurityConfigurerAdapter{
	
//	private final AuthenticationEntryPoint entryPoint;
//	
//	
//	@Autowired
//	public SecurityCatalogConfig(AuthenticationEntryPoint ep) {
//		super();
//		this.entryPoint = ep;
//		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
//	}
//	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
	        .and()
	        .withUser("user").password(encoder().encode("userPass")).roles("USER");
	}
	 
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
        .csrf().disable()
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .httpBasic();
		
//	    http
//	    .csrf().disable()
//	    .exceptionHandling()
//	    //.authenticationEntryPoint(entryPoint)
//	    .and()
//	    .authorizeRequests()
//	    .antMatchers("/ingredientes/**").authenticated()
//	    .antMatchers("/ingredientes/admin/**").hasRole("ADMIN")
//	    .and()
//	    .formLogin()
//	    //.successHandler(succesHandler)
//	    .and()
//	    .logout();
	}

}
