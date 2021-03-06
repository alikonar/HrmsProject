package konar.hrms.business.abstracts;

import java.util.List;

import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.Result;
import konar.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobTitle);
	

}
