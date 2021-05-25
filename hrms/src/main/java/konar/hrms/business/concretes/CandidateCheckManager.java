package konar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konar.hrms.business.abstracts.CandidateCheckService;
import konar.hrms.business.constants.Message;
import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.SuccessDataResult;
import konar.hrms.dataAccess.abstracts.CandidateDao;
import konar.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	
	
	

	@Override
	public boolean checkIfMailExist(Candidate candidate) {
		if(this.findByEmail(candidate.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkIfMailActivation() {
		return true;
	}

	@Override
	public boolean checkIfIdentityExist(Candidate candidate) {
		if(this.findByIdentityNo(candidate.getIdentityNo()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public DataResult<List<Candidate>> findByEmail(String email) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmail(email), Message.candidateEmailListed);
	}

	@Override
	public DataResult<List<Candidate>> findByIdentityNo(String identityNo) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByIdentityNo(identityNo), Message.candidateIdentityNoListed);
	}

}
