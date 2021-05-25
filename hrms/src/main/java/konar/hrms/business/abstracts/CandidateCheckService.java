package konar.hrms.business.abstracts;

import java.util.List;

import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	boolean checkIfMailExist(Candidate candidate);
	boolean checkIfMailActivation();
	boolean checkIfIdentityExist(Candidate candidate);
	
	DataResult<List<Candidate>> findByEmail(String email);
	DataResult<List<Candidate>> findByIdentityNo(String identityNo);

}
