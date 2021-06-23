package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new DataResult<List<Employee>>(this.employeeDao.findAll(), true);
	}

	@Override
	public DataResult<Employee> getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(Employee employee) {
		// TODO Auto-generated method stub		
		return null;
	}

	@Override
	public Result update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
