package kodlamaio.hrms.dataAccess.abstracts.cvInformationDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateImageInformation;

public interface CandidateImageInformationDao extends JpaRepository<CandidateImageInformation, Integer>{

}
