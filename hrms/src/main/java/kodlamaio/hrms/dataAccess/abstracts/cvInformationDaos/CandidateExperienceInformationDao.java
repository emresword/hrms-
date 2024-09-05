package kodlamaio.hrms.dataAccess.abstracts.cvInformationDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateExperienceInformation;

public interface CandidateExperienceInformationDao extends JpaRepository<CandidateExperienceInformation, Integer>{

}
