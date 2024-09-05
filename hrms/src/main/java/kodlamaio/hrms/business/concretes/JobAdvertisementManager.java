package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.SchedulingAwareRunnable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.validations.EntityValidation;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.ErrorResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccesResault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import net.bytebuddy.asm.Advice.This;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
	private EntityValidation<JobAdvertisement> entityValidation;
	private CityDao cityDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao=cityDao;

	}

	@Override
	public DataResault<List<JobAdvertisement>> getAll() {
		return new SuccessDataResault<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"data are listed");
	}

//	@Override
//	@Transactional
//	public Resault add(JobAdvertisement jobAdvertisement) {
//		
//		if (entityValidation.validate(jobAdvertisement)) {
//			return new SuccesResault("Job Advertisement is added");
//		} else {
//			return new ErrorResault("there are validation errors");
//		}
//
//	}
	@Override
	@Transactional
	public Resault add(JobAdvertisement jobAdvertisement) {
		// Validate the job advertisement
		

		// Save the City first if it's a new city
		City city = jobAdvertisement.getCity();
		if (city !=  null) {
			city = cityDao.save(city);
			jobAdvertisement.setCity(city);
		}

		// Save the JobAdvertisement
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccesResault("Job Advertisement is added");
	}

	@Override
	public Resault delete(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resault update(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resault setJobAdvertisementStatusFalse(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.findById(jobAdvertisementId).orElseThrow(
				()-> new IllegalArgumentException("entered id is wrong"+jobAdvertisementId));
		jobAdvertisement.setStatus(false);
		jobAdvertisementDao.saveAndFlush(jobAdvertisement);
		return new SuccesResault("status of job hes been disabled");
	}

	@Override
	public DataResault<List<JobAdvertisement>> findByStatusTrue() {
		return new SuccessDataResault<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatusTrue()," Active job postings have been listed successfully");
	}

	@Override
	public DataResault<List<JobAdvertisement>> findByEmployerCompanyNameIsAndStatusTrue(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResault<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployerCompanyNameIsAndStatusTrue(companyName),  "Active job postings of the company have been successfully listed");
	}

	@Override
	public DataResault<List<JobAdvertisement>> findByStatusTrueOrderByApplicationStart() {
		return new SuccessDataResault<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatusTrueOrderByApplicationStart(),  "The job posting has been listed successfully");
	}

}
