package gdp5.team2.cms.service.ServiceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Menu;
import gdp5.team2.cms.repository.MenuRepository;
import gdp5.team2.cms.service.MenuService;




@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuRepository menuRepository;
	
	@Override
	public Iterable<Menu> findAll() {
		Iterable<Menu> list =  menuRepository.findAll();
		return list;
	}

	@Override
	public Optional<Menu> findById(int id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id);
	}

	@Override
	public void save(Menu entity) {
		menuRepository.save(entity);
	}

	@Override
	public void delete(int entity) {
		menuRepository.deleteById(entity);
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub
		return menuRepository.existsById(id);
	}
}
