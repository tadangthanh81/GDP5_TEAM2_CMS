/**
 * 
 */
package gdp5.team2.cms.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import gdp5.team2.cms.entity.Users;
import gdp5.team2.cms.repository.UserRepository;
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
	UserServiceImpl u;

	UserDetailConfig userDetailConfig;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//				.authorizeRequests().antMatchers("/resources/**", "/login/**").permitAll()
//			.and()
//				.authorizeRequests().antMatchers("/register/**").permitAll()
//			.and()
//				.authorizeRequests().anyRequest().authenticated()
//			.and()
//				.formLogin()
//				.loginPage("/login").usernameParameter("email").passwordParameter("password")
//				.defaultSuccessUrl("/index").failureUrl("/404")
//			.and()
//				.logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
//			.and()
//				.authorizeRequests().antMatchers(HttpMethod.GET, "/news/**","/news").access("hasRole('DEV')")
//			.and()
//				.authorizeRequests().antMatchers("/user/**").access("hasRole('Admin')");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(u);
	}

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
}
