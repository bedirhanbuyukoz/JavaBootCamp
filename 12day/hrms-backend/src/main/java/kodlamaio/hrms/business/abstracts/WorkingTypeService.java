package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {
	
	DataResult<List<WorkingType>> getAll();
	DataResult<WorkingType> getById(int id);
	Result add(WorkingType workingType);
	Result update(WorkingType workingType);
	Result delete(WorkingType workingType);


}
