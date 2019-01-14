package gdp5.team2.cms.service.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Slider;
import gdp5.team2.cms.repository.SliderRepository;
import gdp5.team2.cms.service.SliderService;
@Service
public class SliderServiceImpl implements SliderService{

	@Autowired
	SliderRepository sliderRepository;
	
	@Override
	public Iterable<Slider> findAll() {
		Iterable<Slider> list =  sliderRepository.findAll();
		return list;
	}

	@Override
	public Optional<Slider> findById(int id) {
		// TODO Auto-generated method stub
		return sliderRepository.findById(id);
	}

	@Override
	public void save(Slider entity) {
		sliderRepository.save(entity);
	}

	@Override
	public void delete(int entity) {
		sliderRepository.deleteById(entity);
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub
		return sliderRepository.existsById(id);
	}
}
