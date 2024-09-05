package kodlamaio.hrms.dataAccess.abstracts.cvInformationDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateEducationInformation;

public interface CandidateEducationInformationDao extends JpaRepository<CandidateEducationInformation, Integer>{

}
