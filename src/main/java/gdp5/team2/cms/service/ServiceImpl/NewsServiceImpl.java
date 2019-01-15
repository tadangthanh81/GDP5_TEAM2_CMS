package gdp5.team2.cms.service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.News;
import gdp5.team2.cms.repository.NewscmsRepository;
import gdp5.team2.cms.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewscmsRepository newsRepository;
	
	@Override
	public Iterable<News> findAll() {
		// TODO Auto-generated method stub
		return newsRepository.findAll();
	}

	@Override
	public List<News> search(String title) {
		// TODO Auto-generated method stub
		return newsRepository.findByTitleContaining(title);
	}

	@Override
	public Optional<News> findOne(int id) {
		// TODO Auto-generated method stub
		return newsRepository.findById(id);
	}

	@Override
	public void save(News news) {
		// TODO Auto-generated method stub
		newsRepository.save(news);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		newsRepository.deleteById(id);
	}

	@Override
	public int maxId() {
		// TODO Auto-generated method stub
		return newsRepository.maxId();
	}

}
