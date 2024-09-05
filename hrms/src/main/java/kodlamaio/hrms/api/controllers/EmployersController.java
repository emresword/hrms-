package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	private EmployerService employerService;
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	@GetMapping("/getByEmployerPhoneNumber")
	public DataResault<Employer> getByEmployerPhoneNumber(@RequestParam String phoneNumber){
		return this.employerService.getByEmployerPhoneNumber(phoneNumber);
	}
	@GetMapping("/getByEmployerPhoneNumberAndUserId")
	public DataResault<Employer> getByEmployerPhoneNumberAndUserId(@RequestParam("phoneNumber") String phoneNumber,@RequestParam int userId){
		return this.employerService.getByEmployerPhoneNumberAndUserId(phoneNumber,userId);
	}
	@GetMapping("/getByUserId")
	public DataResault<Employer> getByUserId(@RequestParam int id){
		return this.employerService.getByUserId(id);
	}
	@GetMapping("/getByUserIdIn")
	public DataResault<List<Employer>> getByUserIdIn(@RequestParam List<Integer> userIds){
		return this.employerService.getByUserIdIn(userIds);
	}
	@GetMapping("/getAll")
	public DataResault<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	@GetMapping("/getAllEmployerWithDetails")
	public DataResault<List<EmployerDto>> getAllEmployerWithDetails(){
		return this.employerService.getAllEmployerWithDetails();
	}
	
	
	@PostMapping("/add")
	public Resault add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
}
