package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new DataResult<List<City>>(cityDao.findAll(), false);
	}

	@Override
	public DataResult<City> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(City city) {
		// TODO Auto-generated method stub
		return null;
	}

}
