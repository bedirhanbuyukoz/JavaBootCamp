package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.business.constraints.Messages.ResponseMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService{
	
	private WorkingTimeDao workingTimeDao;
	
	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new DataResult<List<WorkingTime>>(this.workingTimeDao.findAll(), true, ResponseMessages.WorkingTimesListed);
	}

	@Override
	public DataResult<WorkingTime> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(WorkingTime workingTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(WorkingTime workingTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
