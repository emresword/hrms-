package kodlamaio.hrms.dataAccess.abstracts.cvInformationDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateTalentInformation;

public interface CandidateTalentInformationDao extends JpaRepository<CandidateTalentInformation, Integer>{

}
