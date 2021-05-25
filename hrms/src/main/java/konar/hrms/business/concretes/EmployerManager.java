package konar.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konar.hrms.business.abstracts.EmployerCheckService;
import konar.hrms.business.abstracts.EmployerService;
import konar.hrms.business.constants.Message;
import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.ErrorResult;
import konar.hrms.core.utilities.results.Result;
import konar.hrms.core.utilities.results.SuccessDataResult;
import konar.hrms.core.utilities.results.SuccessResult;
import konar.hrms.dataAccess.abstracts.EmployerDao;
import konar.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService=employerCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Message.employersListed);
	}

	@Override
	public Result add(Employer employer) {
		if(!this.employerCheckService.checkIfMailExist(employer)) {
			return new ErrorResult(Message.employerMailExist);
		}
		else if(this.employerCheckService.checkMailActivation()){
			return new ErrorResult(Message.employerNotMailActivation);
		}		
		else if(this.employerCheckService.checkIfMailDomain(employer)) {
			return new ErrorResult(Message.mailDomainRequired);
		}
		else {
			this.employerDao.save(employer);
			return new SuccessResult(Message.employerAdded);
		}
		
	}

}
