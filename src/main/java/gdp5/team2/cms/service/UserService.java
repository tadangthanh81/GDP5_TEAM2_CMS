package gdp5.team2.cms.service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Users;

@Service
public interface UserService {
	Optional<Users> findByEmail(String name);
	
	Set<String> authen(int id);

	Collection<? extends GrantedAuthority> getAuthorities(int id);
}
