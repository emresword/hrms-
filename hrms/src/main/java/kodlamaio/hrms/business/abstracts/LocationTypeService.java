package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.LocationType;

public interface LocationTypeService {
	DataResault<List<LocationType>> getAll();
	Resault add(LocationType LocationType);
}
