package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.validations.EntityValidation;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.ErrorResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccesResault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	private JobTitleDao jobTitleDao;
	private EntityValidation<JobTitle> entityValidation;
    @Autowired
	public JobTitleManager(JobTitleDao jobTitleDao,EntityValidation<JobTitle> entityValidation) {
		super();
		this.jobTitleDao = jobTitleDao;
		this.entityValidation=entityValidation;
	}

	@Override
	public DataResault<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResault<>(jobTitleDao.findAll(),"Data are listed") ;
	}

	@Override
	public Resault add(JobTitle jobTitle) {
		if(entityValidation.validate(jobTitle)) {
			this.jobTitleDao.save(jobTitle);
			return new SuccesResault("job title is added");
		}else {
			return new ErrorResault("there is a issue about adding to job title");
		}
		
	}

}
