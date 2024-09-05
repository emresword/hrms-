package kodlamaio.hrms.business.validations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
@Component
public class JobTitleValidations implements EntityValidation<JobTitle>{
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleValidations(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public boolean validate(JobTitle jobTitle) {
		
//		List<JobTitle> existingJobTitles=this.jobTitleDao.findAll();
//		for(JobTitle jobTitle:existingJobTitles) {
//			if(jobTitle==entity) {
//				return false;
//				
//			}
//		}
//		return true;
		return !jobTitleDao.existsByTitle(jobTitle.getTitle());
		
		
	}

}
