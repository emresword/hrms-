package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LocationTypeService;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.LocationTypeDao;
import kodlamaio.hrms.entities.concretes.LocationType;
@Service
public class LocationTypeManager implements LocationTypeService{
	private LocationTypeDao locationTypeDao;
	
	
	@Autowired
	public LocationTypeManager(LocationTypeDao locationTypeDao) {
		super();
		this.locationTypeDao = locationTypeDao;
	}

	@Override
	public DataResault<List<LocationType>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResault<>(this.locationTypeDao.findAll(),"Data are listed");
	}

	@Override
	public Resault add(LocationType LocationType) {
		// TODO Auto-generated method stub
		return null;
	}

}
