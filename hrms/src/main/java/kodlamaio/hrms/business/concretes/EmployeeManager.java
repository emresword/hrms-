package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.validations.EntityValidation;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.ErrorResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccesResault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;
	private EntityValidation<Employee> entityValidation;
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,EntityValidation<Employee> entityValidation) {
		super();
		this.employeeDao = employeeDao;
		this.entityValidation=entityValidation;
	}

	@Override
	public DataResault<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return  new SuccessDataResault<>(employeeDao.findAll(),"Data are listed") ;
	}

	@Override
	public Resault add(Employee employee) {
		// TODO Auto-generated method stub
		if (this.entityValidation.validate(employee)) {
			this.employeeDao.save(employee);
			return new SuccesResault("Employee is Added");
		} else {
			return new ErrorResault("there is a issue about adding an employee");
		}
		
	}
	

}
