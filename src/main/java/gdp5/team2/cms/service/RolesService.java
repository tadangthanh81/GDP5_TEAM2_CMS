package gdp5.team2.cms.service;

import java.util.Optional;

import gdp5.team2.cms.entity.Roles;

public interface RolesService {
	Iterable<Roles> findAll();
	Optional<Roles> findOne(int id);
	void save(Roles role);
}
