package gdp5.team2.cms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gdp5.team2.cms.entity.Menu;




public interface MenuRepository extends CrudRepository<Menu, Integer> {

//    List<Menu> findByNameContaining(String q);
	

}
