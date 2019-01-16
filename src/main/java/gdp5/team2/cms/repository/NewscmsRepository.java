/**
 * 
 */
package gdp5.team2.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gdp5.team2.cms.entity.News;

/**
 * @author User
 *
 */

public interface NewscmsRepository extends CrudRepository<News, Integer> {
	
	List<News> findByTitleContaining(String q);

	@Query(value = "select max(n.newsID) from News n")
	int maxId();
}
