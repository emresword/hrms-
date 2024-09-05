package kodlamaio.hrms.business.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Component
public class JobAdvertisementValidation implements EntityValidation<JobAdvertisement>{
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementValidation(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}


	@Override
	public boolean validate(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary()>jobAdvertisement.getMinSalary()) {
			return true;
		}else {
			return false;
		}
		
	}

}
