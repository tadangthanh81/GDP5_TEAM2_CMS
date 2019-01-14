package gdp5.team2.cms.service;


import java.util.Optional;

import gdp5.team2.cms.entity.Menu;




public interface MenuService {

	public Iterable<Menu> findAll();
	
	public Optional<Menu> findById(int id);
	
	public void save(Menu contact);
	
	public void delete(int id);
	
	public boolean existsById(int id);
	
}
