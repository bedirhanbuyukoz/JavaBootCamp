package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.business.constraints.Messages.ResponseMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTypeDao;
import kodlamaio.hrms.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService {
	
	private WorkingTypeDao workingTypeDao;

	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		return new DataResult<List<WorkingType>>(this.workingTypeDao.findAll(), true, ResponseMessages.WorkingTypesListed);
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(WorkingType workingType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(WorkingType workingType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(WorkingType workingType) {
		// TODO Auto-generated method stub
		return null;
	}

}
