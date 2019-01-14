package gdp5.team2.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdp5.team2.cms.entity.Menu;
import gdp5.team2.cms.service.MenuService;



public class MenuController {

	@RestController
	@RequestMapping("/api")
	public class EmployeeRestController {

		private MenuService menusService;

		@Autowired
		public EmployeeRestController(MenuService theMenusService) {
			menusService = theMenusService;
		}

		@GetMapping("/menus")
		public List<Menu> findAll() {
			return menusService.findAll();
		}

		@GetMapping("/menus/{menuId}")
		public Menu getEmployee(@PathVariable int menuId) {

			Menu theMenu = menusService.findById(menuId);

			if (theMenu == null) {
				throw new RuntimeException("Menu id not found - " + menuId);
			}

			return theMenu;
		}

		@PostMapping("/menus")
		public Menu addMenu(@RequestBody Menu theMenu) {

			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update

			theMenu.setMenuID(0);

			menusService.save(theMenu);

			return theMenu;
		}

		@PutMapping("/menus")
		public Menu updateMenu(@RequestBody Menu theMenu) {

			menusService.save(theMenu);

			return theMenu;
		}

		@DeleteMapping("/menus/{menuId}")
		public String deleteMenu(@PathVariable int menuId) {

			Menu tempMenu = menusService.findById(menuId);

			// throw exception if null

			if (tempMenu == null) {
				throw new RuntimeException("Menu id not found - " + menuId);
			}

			menusService.deleteById(menuId);

			return "Deleted menu id - " + menuId;
		}

	}
}
