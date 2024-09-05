package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface EmployerService {
	Resault add(Employer employer);
	DataResault<List<Employer>> getAll();
	DataResault<Employer> getByUserId(int id);
	DataResault<Employer> getByEmployerPhoneNumber(String phoneNumber);
	DataResault<Employer> getByEmployerPhoneNumberAndUserId(String phoneNumber,int userId);
	DataResault<List<Employer>> getByUserIdIn(List<Integer> userIds);//
	DataResault<List<Employer>> getByEmployerPhoneNumberContains(String phoneNumber);
	DataResault<List<Employer>> getByEmployerPhoneNumberStartsWith(String phoneNumber);
	DataResault<List<EmployerDto>> getAllEmployerWithDetails();
	
}
