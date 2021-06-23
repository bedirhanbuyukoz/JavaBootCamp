package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdDetailsDto;

public interface JobAdService {
	
	DataResult<List<JobAd>> getAll();
	DataResult<List<JobAdDetailsDto>> getJobAdsInDetails();
	DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsById(int id);
	DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsSortedByDate(int ...employerId);
	DataResult<JobAd> getById(int id);
	Result add(JobAd jobAd);
	Result update(JobAd jobAd);
	Result delete(JobAd jobAd);
	Result deactivateJobAd(JobAdDetailsDto jobAdDetailsDto);
	

}
