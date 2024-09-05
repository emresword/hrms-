package kodlamaio.hrms.business.validations;

import java.util.List;

import javax.validation.Path.ReturnValueNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.dataAccess.abstracts.CandidatesDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Component
public class CandidateValidations extends UserValidation<Candidate> {
	private CandidatesDao candidatesDao;
	
	
	@Autowired
	public CandidateValidations(CandidatesDao candidatesDao,UserDao userDao) {
		super(userDao);
		this.candidatesDao = candidatesDao;
		
	}
	@Override
	public boolean validate(Candidate candidate) {
		
//		List<Candidate> existingCandidates=this.candidatesDao.findAll();
//		for(Candidate entity:existingCandidates) {
//			if(entity.getUser().getEmail().equals(candidate.getUser().getEmail())||entity.getIdentityNumber().equals(candidate.getIdentityNumber())) {
//				return false;
//			}
//		}
//		return true;
		 if (!super.validate(candidate)) {
			 System.out.print("same email");
	            return false;
	        }
		 else if(candidatesDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			 System.out.print("same identity number");
	            return false;
		 }else {
			 return true;
		 }
	        // Candidate'e özgü validasyonlar burada yapılır
	       
			
		
	}

	
	




	
	
	
	
}
