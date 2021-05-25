package konar.hrms.business.abstracts;

import java.util.List;

import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.entities.concretes.JobTitle;

public interface JobTitleCheckService {
	
	boolean checkIfTitleExist(JobTitle jobTitle);
	DataResult<List<JobTitle>> findByTitle(String title);
	

}
