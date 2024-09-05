package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.Employee;


public interface EmployeeService {
	DataResault<List<Employee>> getAll();
	Resault add(Employee employee);
}
