/**
 * 
 */
package gdp5.team2.cms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import gdp5.team2.cms.service.ServiceImpl.UserServiceImpl;

/**
 * @author User
 *
 */
@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests().antMatchers("/resources/**", "/login/**").permitAll()
					.antMatchers("/register/**").permitAll()
			.antMatchers(HttpMethod.GET,"/user/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers(HttpMethod.GET, "/news/**").access("hasRole('ROLE_DEV') or hasRole('ROLE_ADMIN')")
			.antMatchers(HttpMethod.GET, "/slider/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DEV')")
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login").usernameParameter("email").passwordParameter("password")
				.defaultSuccessUrl("/index").failureUrl("/login")
			.and()
				.logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
				
				
			;
		http.exceptionHandling().accessDeniedPage("/404");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl);
	}

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
}
