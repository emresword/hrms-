package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.validation.Path.ReturnValueNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validations.EntityValidation;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.ErrorResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccesResault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.EmployerDto;
import kodlamaio.hrms.entities.verifications.VerificationCodeCandidate;
import net.bytebuddy.asm.Advice.This;
@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EntityValidation<Employer> entityValidation;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EntityValidation<Employer> entityValidation) {
		super();
		this.employerDao = employerDao;
		this.entityValidation = entityValidation;
	}

	@Override
	public DataResault<Employer> getByEmployerPhoneNumber(String phoneNumber) {
		return new SuccessDataResault<Employer>
		(this.employerDao.getByPhoneNumber(phoneNumber),"Data are listed");
	}


	@Override
	public DataResault<List<Employer>> getByUserIdIn(List<Integer> userIds) {
		return new SuccessDataResault<List<Employer>>
		(this.employerDao.getByIdIn(userIds),"Data are listed");
	}

	@Override
	public DataResault<List<Employer>> getByEmployerPhoneNumberContains(String phoneNumber) {
		return new SuccessDataResault<List<Employer>>
		(this.employerDao.getByPhoneNumberContains(phoneNumber),"Data are listed");
	}

	@Override
	public DataResault<List<Employer>> getByEmployerPhoneNumberStartsWith(String phoneNumber) {
		return new SuccessDataResault<List<Employer>>
		(this.employerDao.getByPhoneNumberStartsWith(phoneNumber),"Data are listed");
	}


//employer eklerken eğer one to many veya one to one la 
//olan field lar veri tabanında gözükmesse burda onların null olup olmadığını kontol et
	@Override
	@Transactional
	public Resault add(Employer employer) {
		
		 if (employer.getJobAdvertisements() != null) {
		        for (JobAdvertisement jobAdvertisement : employer.getJobAdvertisements()) {
		            jobAdvertisement.setEmployer(employer);
		        }
		    }
		
		
		
		if(entityValidation.validate(employer)) {
			this.employerDao.save(employer);
			return new SuccesResault("employer is added");
		}else {
			return new ErrorResault("there are invalid inputs");
		}
		
	}

	@Override
	public DataResault<Employer> getByUserId(int id) {
		return new SuccessDataResault<Employer>
		(this.employerDao.getById(id),"dara are listed");
	}

	@Override
	public DataResault<Employer> getByEmployerPhoneNumberAndUserId(String phoneNumber, int userId) {
		
		return new SuccessDataResault<Employer>
		(this.employerDao.getByEmployerPhoneNumberAndUserId(phoneNumber,userId),"dara are listed");
	}

	@Override
	public DataResault<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResault<>(this.employerDao.findAll(),"data are listed");
	}

	@Override
	public DataResault<List<EmployerDto>> getAllEmployerWithDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResault<List<EmployerDto>>(this.employerDao.getAllEmployerWithDetails(),"Employer are listed with detail");
	}

}
