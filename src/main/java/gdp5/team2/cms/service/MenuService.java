package gdp5.team2.cms.service;

import java.util.List;

import gdp5.team2.cms.entity.Menu;

public interface MenuService {
	public List<Menu> findAll();

	public Menu findById(int theId);

	public void save(Menu theMenu);

	public void deleteById(int theId);
}
