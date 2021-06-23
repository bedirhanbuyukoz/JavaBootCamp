package kodlamaio.hrms.business.concretes;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdDao;
import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdDetailsDto;

@Service
public class JobAdManager implements JobAdService{
	
	private JobAdDao jobAdDao;

	@Autowired
	public JobAdManager(JobAdDao jobAdDao) {
		super();
		this.jobAdDao = jobAdDao;
	}

	@Override
	public DataResult<List<JobAd>> getAll() {
		return new SuccessDataResult<List<JobAd>>(jobAdDao.findAll());
	}

	@Override
	public DataResult<JobAd> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(JobAd jobAd) {
		jobAdDao.save(jobAd);
		return new Result(true, "Job Ad has been saved to the system!");
	}

	@Override
	public Result update(JobAd jobAd) {
		return null;
	}

	@Override
	public Result delete(JobAd jobAd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetails() {
		return new SuccessDataResult<List<JobAdDetailsDto>>(jobAdDao.getJobAdsInDetails());
	}
	
	@Override
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsById(int id) {
		return new SuccessDataResult<List<JobAdDetailsDto>>(jobAdDao.getJobAdsInDetailsById(id));
	}

	@Override
	public DataResult<List<JobAdDetailsDto>> getJobAdsInDetailsSortedByDate(int ...employerId) {
		
		List<JobAdDetailsDto> jobAdDetailsList;
		
		if(employerId == null) {
			return new ErrorDataResult<List<JobAdDetailsDto>>("Please add an employerId into parameters!");
		}
		
		if (employerId.length > 0) {
			jobAdDetailsList = jobAdDao.getJobAdsInDetailsByEmployerId(employerId[0]);			
		} else {
			jobAdDetailsList = jobAdDao.getJobAdsInDetails();
		}
		
		Collections.sort(jobAdDetailsList,  (j1, j2) -> {
			if (j1.getPublishedAt().isBefore(j2.getPublishedAt())) return 1;
			else return -1;
		});
		
		return new SuccessDataResult<List<JobAdDetailsDto>>(jobAdDetailsList);
	}

	@Override
	public Result deactivateJobAd(JobAdDetailsDto jobAdDetailsDto) {
		//JobAdDetailsDto jobAdToUpdate = jobAdDao.
		return null;
	}

}
