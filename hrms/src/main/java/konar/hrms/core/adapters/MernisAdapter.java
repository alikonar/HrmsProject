package konar.hrms.core.adapters;

import org.springframework.stereotype.Service;

import konar.hrms.entities.concretes.Candidate;

@Service
public class MernisAdapter implements CheckIfRealPersonService {

	@Override
	public boolean checkIfReal(Candidate candidate) {
		
		if(candidate.getIdentityNo().length()!=11) {
			return false;
		}
		return true;
		
		
	}

}
