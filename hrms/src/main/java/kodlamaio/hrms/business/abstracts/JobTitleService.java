package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResault<List<JobTitle>> getAll();
	Resault add(JobTitle jobTitle);
}
