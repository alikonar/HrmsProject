package konar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konar.hrms.business.abstracts.JobTitleCheckService;
import konar.hrms.business.abstracts.JobTitleService;
import konar.hrms.business.constants.Message;
import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.ErrorResult;
import konar.hrms.core.utilities.results.Result;
import konar.hrms.core.utilities.results.SuccessDataResult;
import konar.hrms.core.utilities.results.SuccessResult;
import konar.hrms.dataAccess.abstracts.JobTitleDao;
import konar.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	private JobTitleCheckService jobTitleCheckService;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao, JobTitleCheckService jobTitleCheckService) {
		super();
		this.jobTitleDao = jobTitleDao;
		this.jobTitleCheckService = jobTitleCheckService;

	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), Message.jobTitleListed);

	}

	@Override
	public Result add(JobTitle jobTitle) {

		if (!this.jobTitleCheckService.checkIfTitleExist(jobTitle)) {
			return new ErrorResult(Message.titleExist);
		} else {
			this.jobTitleDao.save(jobTitle);
			return new SuccessResult(Message.jobTitleAdded);
		}

	}

}
