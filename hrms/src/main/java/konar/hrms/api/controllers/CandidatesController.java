package konar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import konar.hrms.business.abstracts.CandidateService;
import konar.hrms.core.utilities.results.DataResult;
import konar.hrms.core.utilities.results.Result;
import konar.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();

	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}

}
