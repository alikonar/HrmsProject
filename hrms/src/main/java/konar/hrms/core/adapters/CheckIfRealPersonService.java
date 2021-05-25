package konar.hrms.core.adapters;

import konar.hrms.entities.concretes.Candidate;

public interface CheckIfRealPersonService {
	
	boolean checkIfReal(Candidate candidate);

}
