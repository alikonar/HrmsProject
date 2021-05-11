package konar.hrms.business.abstracts;

import java.util.List;

import konar.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	List<JobTitle> getAll();

}
