package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	Candidate getById(int id);
	
	Candidate getByIdentityNumber(String identityNumber);
	
	//@Query(value = "SELECT usr.* FROM applicant usr WHERE usr.identity_number=(:identity_number)", nativeQuery = true)    
	//public List<Candidate> findIdentityNumber(@Param("identity_number") String identity_number);	

}
