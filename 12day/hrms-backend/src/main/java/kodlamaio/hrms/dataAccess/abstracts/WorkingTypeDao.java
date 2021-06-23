package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkingType;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer> {
	
	WorkingType findById(int id);
	WorkingType findByName(String name);

}
