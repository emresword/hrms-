package kodlamaio.hrms.business.validations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Component
public class EmployerValidations extends UserValidation<Employer>{
	private EmployerDao employerDao;
	@Autowired
	public EmployerValidations(EmployerDao employerDao,UserDao userDao) {
		super(userDao);
		this.employerDao = employerDao;
	}

	@Override
	public boolean validate(Employer employer) {
//		boolean isExist=true;
//		List<Employer> existEmployers=employerDao.findAll();
//		for(Employer entity:existEmployers) {
//			if(entity==employer) {
//				isExist=false;
//				break;
//			}
//		}
//		return isExist;
		 
		 return super.validate(employer);

	}
	

}
