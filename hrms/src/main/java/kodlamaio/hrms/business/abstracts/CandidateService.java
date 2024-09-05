package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.business.requests.CreateCandidateRequest;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


public interface CandidateService {
	DataResault<List<Candidate>> getAll();
	Resault add(Candidate candidate);
	DataResault<List<CandidateCvDto>>  findAllCandidatesWithDetails();
	DataResault<List<Candidate>> getAllActiveCandidates();
	DataResault<Candidate> getById(int id);
//	sonra aç
}
