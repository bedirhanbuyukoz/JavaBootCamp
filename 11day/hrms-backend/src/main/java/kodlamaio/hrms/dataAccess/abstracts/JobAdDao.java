package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdDetailsDto;

public interface JobAdDao extends JpaRepository<JobAd, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdDetailsDto(j.id, e.companyName, jt.name, j.openPositionQty, j.publishedAt, j.deadline, j.isActive) From JobAd j Inner Join j.employer e Inner Join j.jobTitle jt where j.isActive = true")
	List<JobAdDetailsDto> getJobAdsInDetails();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdDetailsDto(j.id, e.companyName, jt.name, j.openPositionQty, j.publishedAt, j.deadline,  j.isActive) From JobAd j Inner Join j.employer e Inner Join j.jobTitle jt where j.isActive = true and j.id = :id")
	List<JobAdDetailsDto> getJobAdsInDetailsById(int id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdDetailsDto(j.id, e.companyName, jt.name, j.openPositionQty, j.publishedAt, j.deadline,  j.isActive) From JobAd j Inner Join j.employer e Inner Join j.jobTitle jt where j.isActive = true and e.id = :employerId")
	List<JobAdDetailsDto> getJobAdsInDetailsByEmployerId(int employerId);
	
	

}
