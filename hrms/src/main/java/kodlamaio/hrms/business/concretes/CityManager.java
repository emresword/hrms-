package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.validations.EntityValidation;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.ErrorResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccesResault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	private EntityValidation<City> entityValidation;
	
	
	@Autowired
	public CityManager(CityDao cityDao,EntityValidation<City> entityValidation) {
		super();
		this.cityDao = cityDao;
		this.entityValidation=entityValidation;
	}

	@Override
	public DataResault<List<City>> getAll() {
	    return new SuccessDataResault<List<City>>(this.cityDao.findAll(), "Data are listed");
	}

	@Override
	@Transactional
	public Resault add(City city) {
		if (entityValidation.validate(city)) {
			   this.cityDao.save(city);
			    return new SuccesResault("City is successfully added");
		} else {
			
			 return new ErrorResault("There is a issue about adding city");
		}
	 
	 
	}


}
