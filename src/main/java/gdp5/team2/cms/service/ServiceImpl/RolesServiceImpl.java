package gdp5.team2.cms.service.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Roles;
import gdp5.team2.cms.repository.RolesRepository;
import gdp5.team2.cms.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	RolesRepository rolesRepository;
	@Override
	public Iterable<Roles> findAll() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

	@Override
	public Optional<Roles> findOne(int id) {
		// TODO Auto-generated method stub
		return rolesRepository.findById(id);
	}

	@Override
	public void save(Roles role) {
		// TODO Auto-generated method stub
		rolesRepository.save(role);
	}
	
}
