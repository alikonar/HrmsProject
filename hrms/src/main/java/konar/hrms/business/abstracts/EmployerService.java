package konar.hrms.business.abstracts;

import java.util.List;

import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.Result;
import konar.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	
	
}
