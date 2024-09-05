package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResault<List<JobAdvertisement>> getAll();

	Resault add(JobAdvertisement jobAdvertisement);

	Resault delete(JobAdvertisement jobAdvertisement);

	Resault update(JobAdvertisement jobAdvertisement);

	Resault setJobAdvertisementStatusFalse(int jobAdvertisementId);

	DataResault<List<JobAdvertisement>> findByStatusTrue();

	DataResault<List<JobAdvertisement>> findByEmployerCompanyNameIsAndStatusTrue(String companyName);
	DataResault<List<JobAdvertisement>> findByStatusTrueOrderByApplicationStart();

}
