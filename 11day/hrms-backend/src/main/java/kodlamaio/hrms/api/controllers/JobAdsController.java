package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdDetailsDto;

@RestController
@RequestMapping("api/jobads")
@CrossOrigin
public class JobAdsController {
	
	private JobAdService jobAdService;

	@Autowired
	public JobAdsController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAd>> getAll(){
		return this.jobAdService.getAll();
	}
	
	@GetMapping("/getJobAdsInDetails")
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetails(){
		return this.jobAdService.getJobAdsInDetails();
	}
	
	@GetMapping("/getJobAdsInDetailsById")
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsById(int id){
		return this.jobAdService.getJobAdsInDetailsById(id);
	}
	
	@GetMapping("/getJobAdsInDetailsSortedByDate")
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsSortedByDate(){
		return this.jobAdService.getJobAdsInDetailsSortedByDate();
	}
	
	@GetMapping("/getJobAdsInDetailsByCompanySortedByDate")
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsByCompanySortedByDate(int ...employerId){
		return this.jobAdService.getJobAdsInDetailsSortedByDate(employerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAd jobAd){
		return this.jobAdService.add(jobAd);
	}

}
