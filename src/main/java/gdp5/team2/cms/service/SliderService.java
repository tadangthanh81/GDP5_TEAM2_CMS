package gdp5.team2.cms.service;

import java.util.Optional;

import gdp5.team2.cms.entity.Slider;

public interface SliderService {

	public Iterable<Slider> findAll();
	
	public Optional<Slider> findById(int id);
	
	public void save(Slider entity);
	
	public void delete(int id);
	
	public boolean existsById(int id);
}
