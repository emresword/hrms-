package kodlamaio.hrms.business.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;


@Component
public class CityValidations implements EntityValidation<City>{
	private	CityDao cityDao;
	@Autowired
	public CityValidations(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}



	@Override
	public boolean validate(City city) {
		// TODO Auto-generated method stub
		return !this.cityDao.existsByCityName(city.getCityName());
	}

}
