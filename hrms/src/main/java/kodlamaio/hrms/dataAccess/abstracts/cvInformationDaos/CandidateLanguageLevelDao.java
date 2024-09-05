package kodlamaio.hrms.dataAccess.abstracts.cvInformationDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateLanguegeLevel;
public interface CandidateLanguageLevelDao extends JpaRepository<CandidateLanguegeLevel, Integer>{

}
