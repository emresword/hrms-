package kodlamaio.hrms.business.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
@Component
public class UserValidation<T extends User> implements EntityValidation<T>{
	private UserDao userDao;
	
	@Autowired
	public UserValidation(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public boolean validate(User entity) {
		// TODO Auto-generated method stub
		return !userDao.existsByEmail(entity.getEmail());
	}

}
