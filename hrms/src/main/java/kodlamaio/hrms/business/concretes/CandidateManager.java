package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.requests.CreateCandidateRequest;
import kodlamaio.hrms.business.validations.EntityValidation;
import kodlamaio.hrms.core.mappers.ModelMapperService;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.ErrorResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.core.utilities.results.SuccesResault;
import kodlamaio.hrms.core.utilities.results.SuccessDataResault;
import kodlamaio.hrms.dataAccess.abstracts.CandidatesDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateCoverLetter;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateEducationInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateExperienceInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateImageInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateLanguegeLevel;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateTalentInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateWebAddress;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;
import kodlamaio.hrms.entities.verifications.VerificationCodeCandidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidatesDao candidatesDao;
	private EntityValidation<Candidate> entityValidation;
	private ModelMapperService modelMapperService;

	@Autowired
	public CandidateManager(CandidatesDao candidatesDao, EntityValidation<Candidate> entityValidation,
			ModelMapperService modelMapperService) {
		super();
		this.candidatesDao = candidatesDao;
		this.entityValidation = entityValidation;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResault<List<Candidate>> getAll() {
		return new SuccessDataResault<>(candidatesDao.findAll(), "Data are listed");
	}

	@Override
	@Transactional
	public Resault add(Candidate candidate) {

//		VerificationCodeCandidate verificationCode = new VerificationCodeCandidate();
//		verificationCode.setCandidate(candidate); // Set the candidate
//
//		candidate.setVerificationCodeCandidate(verificationCode);
//
//		if (verificationCode != null) {
//			System.out.println("Verification code candidate: " + verificationCode.getCode());
//		}
		
		
		//The reason I am writing these is that the candidate ID(candidate ıd) cannot be seen in the databases.
		
		if (candidate.getVerificationCodeCandidate() != null) {
			VerificationCodeCandidate verificationCode = candidate.getVerificationCodeCandidate();
			verificationCode.setCandidate(candidate); 
        }
		
		
		if (candidate.getCandidateCoverLetter() != null) {
            for (CandidateCoverLetter coverLetter : candidate.getCandidateCoverLetter()) {
                coverLetter.setCandidate(candidate);
            }
        }

        if (candidate.getCandidateEducationInformation() != null) {
            for (CandidateEducationInformation education : candidate.getCandidateEducationInformation()) {
                education.setCandidate(candidate);
            }
        }

        if (candidate.getCandidateExperienceInformation() != null) {
            for (CandidateExperienceInformation experience : candidate.getCandidateExperienceInformation()) {
                experience.setCandidate(candidate);
            }
        }

        if (candidate.getCandidateImageInformation() != null) {
            for (CandidateImageInformation imageInfo : candidate.getCandidateImageInformation()) {
                imageInfo.setCandidate(candidate);
            }
        }

        if (candidate.getCandidateLanguegeLevel() != null) {
            for (CandidateLanguegeLevel languageLevel : candidate.getCandidateLanguegeLevel()) {
                languageLevel.setCandidate(candidate);
            }
        }

        if (candidate.getCandidateTalentInformation() != null) {
            for (CandidateTalentInformation talentInfo : candidate.getCandidateTalentInformation()) {
                talentInfo.setCandidate(candidate);
            }
        }

        if (candidate.getCandidateWebAddresses() != null) {
            for (CandidateWebAddress webAddress : candidate.getCandidateWebAddresses()) {
                webAddress.setCandidate(candidate);
            }
        }


		if (entityValidation.validate(candidate)) {
			this.candidatesDao.save(candidate);
			return new SuccesResault("Candidate is successfully added");
		} else {
			return new ErrorResault("There are invalid inputs");
		}
	}

	public DataResault<List<CandidateCvDto>> findAllCandidatesWithDetails() {
		return new SuccessDataResault<List<CandidateCvDto>>(candidatesDao.findAllCandidatesWithDetails(),
				"Data are listed");
	}

	@Override
	public DataResault<List<Candidate>> getAllActiveCandidates() {
		return new SuccessDataResault<List<Candidate>>(candidatesDao.getAllActiveCandidates(),
				"Active candidates are listed");
	}
	  @Override
	    public DataResault<Candidate> getById(int id) {
	        Candidate candidate = this.candidatesDao.getById(id);
	        return new SuccessDataResault<>(candidate, "Candidate is successfully fetched");
	    }
	// sonra ac

//	@Override
//    public Resault add(CreateCandidateRequest createCandidateRequest) {
//    	Candidate candidate=modelMapperService.forRequest().map(createCandidateRequest, Candidate.class);
//        if (entityValidation.validate(candidate)) {
//            this.candidatesDao.save(candidate);
//            return new SuccesResault("Candidate is successfully added");
//        } else {
//            return new ErrorResault("There are invalid inputs");
//        }
//    }

}
