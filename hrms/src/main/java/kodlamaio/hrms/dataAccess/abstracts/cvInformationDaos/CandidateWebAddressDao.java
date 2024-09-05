package kodlamaio.hrms.dataAccess.abstracts.cvInformationDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateWebAddress;

public interface CandidateWebAddressDao extends JpaRepository<CandidateWebAddress, Integer>{

}
