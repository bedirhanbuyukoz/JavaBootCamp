package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.constraints.Messages.ResponseMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new DataResult<List<Candidate>>(this.candidateDao.findAll(), true, ResponseMessages.candidatesListed);
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

	@Override
	public Result add(Candidate candidate) {
		
		this.candidateDao.save(candidate);
		
		return new Result(true, ResponseMessages.candidateAdded);
	}

	@Override
	public Result update(Candidate candidate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Candidate candidate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean identityNumberExists(String identityNumber) {
		
        if(this.candidateDao.getByIdentityNumber(identityNumber).equals(null)) {
            return false;
        }
        
        return true;
    }

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber));
	}

}
