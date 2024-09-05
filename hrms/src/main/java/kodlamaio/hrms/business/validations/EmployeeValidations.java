package kodlamaio.hrms.business.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employee;
@Component
public class EmployeeValidations extends UserValidation<Employee>{
	private EmployeeDao employeeDao;

	public EmployeeValidations(UserDao userDao,EmployeeDao employeeDao) {
		super(userDao);
		this.employeeDao=employeeDao;
	}
	@Override
	public boolean validate(Employee employee) {
		if(!super.validate(employee)) {
			 System.out.print("same email");
	            return false;
			
		}else {
			return true;
			
		}
		
	}

}
