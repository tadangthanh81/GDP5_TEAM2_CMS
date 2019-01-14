package gdp5.team2.cms.service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Menu;
import gdp5.team2.cms.repository.MenuRepository;
import gdp5.team2.cms.service.MenuService;


@Service
public class MenuServiceImpl implements MenuService {

	private MenuRepository menusRepository;

	@Autowired
	public MenuServiceImpl(MenuRepository theMenusRepository) {
		menusRepository = theMenusRepository;
	}

	@Override
	public List<Menu> findAll() {
		return menusRepository.findAll();
	}

	@Override
	public Menu findById(int theId) {
		Optional<Menu> result = menusRepository.findById(theId);

		Menu theMenu = null;

		if (result.isPresent()) {
			theMenu = result.get();
		} else {

			throw new RuntimeException("Did not find menu id - " + theId);
		}

		return theMenu;
	}

	@Override
	public void save(Menu theMenu) {
		menusRepository.save(theMenu);
	}

	@Override
	public void deleteById(int theId) {
		menusRepository.deleteById(theId);
	}

}
