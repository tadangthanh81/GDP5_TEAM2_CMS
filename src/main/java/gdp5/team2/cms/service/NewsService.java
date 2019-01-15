package gdp5.team2.cms.service;

import java.util.List;
import java.util.Optional;

import gdp5.team2.cms.entity.News;


public interface NewsService {
	Iterable<News> findAll();

	List<News> search(String q);

	Optional<News> findOne(int id);

	void save(News contact);

	void delete(int id);
	
	int maxId();
}
