package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobTitles")
@CrossOrigin
public class JobTitlesController {

	private JobTitleService jobTitleService;
	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getAll")
	public DataResault<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	@PostMapping("/add")
	public Resault add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}

}
