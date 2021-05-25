package konar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konar.hrms.business.abstracts.JobTitleCheckService;
import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.SuccessDataResult;
import konar.hrms.dataAccess.abstracts.JobTitleDao;
import konar.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleCheckManager implements JobTitleCheckService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleCheckManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> findByTitle(String title) {
	
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findByTitle(title));
		
		
	}
	
	
	@Override
	public boolean checkIfTitleExist(JobTitle jobTitle) {
		
		if(this.findByTitle(jobTitle.getTitle()).getData().size()!=0) {
			return false;
		}else {
			return true;
		}
		
		
	}


	

}
