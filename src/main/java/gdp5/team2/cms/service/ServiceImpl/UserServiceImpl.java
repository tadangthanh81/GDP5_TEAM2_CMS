package gdp5.team2.cms.service.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Users;
import gdp5.team2.cms.repository.UserRepository;
import gdp5.team2.cms.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<Users> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Set<String> authen(int id) {
		Set<String> listAuthen = new HashSet<>();
		List<String> s = userRepository.authen(id);
		for (String d : s) {
			String[] n = d.split(",");
			for (String j : n) {
				listAuthen.add("ROLE_" + j.toUpperCase());
			}
		}
		return listAuthen;
//		return this.role = userRepository.authen(id);
	}

	public List<GrantedAuthority> getGrantedAuthority(Set<String> authen) {
		List<GrantedAuthority> authorities = new ArrayList();
		for (String au : authen) {
			authorities.add(new SimpleGrantedAuthority(au));
		}
		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(int id) {
		// TODO Auto-generated method stub
		return getGrantedAuthority(authen(id));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDetails cs = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Optional<Users> user = userRepository.findByEmail(username);
		System.out.println(getGrantedAuthority(authen(user.get().getUserID())));
		return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
				passwordEncoder().encode(user.get().getPassword()),
				getGrantedAuthority(authen(user.get().getUserID())));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public Iterable<Users> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	
	@Override
	public Optional<Users> findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void save(Users user) {
		userRepository.save(user);
		
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
		
	}
}
