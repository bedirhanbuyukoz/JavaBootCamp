package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getById(int id);
	DataResult<User> getByEmail(String email);
	Result add(User user);
	Result update(User user);
	Result delete(User user);
}
