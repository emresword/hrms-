package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidatesDao extends JpaRepository<Candidate, Integer> {
	boolean existsByEmail(String email);

	boolean existsByIdentityNumber(String identityNumber);
	@Query("SELECT new kodlamaio.hrms.entities.dtos.CandidateCvDto"
			+ "(c.id, c.firstName,c.lastName,cover.coverLetter,edu.schoolName,edu.department,edu.degree,edu.startDate,edu.endDate,exp.institution,exp.role,exp.jobStartDate,exp.jobEndDate,lang.languageName,lang.languageLevel,web.webLink,talent.knownTechnology)"
			+ " From Candidate c inner join c.candidateCoverLetter cover "
			+ "inner join c.candidateEducationInformation edu "
			+ "inner join c.candidateExperienceInformation exp "
			+ "inner join c.candidateLanguegeLevel lang "
			+ "inner join c.candidateWebAddresses web "
			+ "inner join c.candidateTalentInformation talent ")
	List<CandidateCvDto> findAllCandidatesWithDetails();
	
	@Query("From Candidate c inner join c.verificationCodeCandidate ver where ver.isVerified=true ")
	List<Candidate> getAllActiveCandidates();
	Candidate getById(int id);
//	bunu sonra aç


}

