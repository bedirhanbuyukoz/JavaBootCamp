package kodlamaio.hrms.business.concretes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.UserForLoginDto;

@Service
public class AuthManager implements AuthService{
	
	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result login(UserForLoginDto userForLoginDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		
		if (checkIfEmployerDataComplete(employer) == false) {
			return new ErrorResult("You have entered missing information. Please fill in all fields!");
		}
		
		if (checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + " already exists!");
		}
		
		if (checkIfEmailMatchesDomain(employer.getEmail(), employer.getWebsite()) == false) {
			return new ErrorResult("Invalid email address! Please enter your company email adress.");
		}
		
		if (checkIfPasswordAndConfirmPasswordMatches(employer.getPassword(), confirmPassword) == false) {
			return new ErrorResult("Passwords do not match!");
		}
		
		employerService.add(employer);
		String code = verificationService.sendCode();
		String verificationResponse = saveVerificationCodeToDb(code, userService.getByEmail(employer.getEmail()).getData().getId(), employer.getEmail());
		return new SuccessResult("Registration has been successfully completed! " + verificationResponse);		
		
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		
		if (checkIfCandidateDataComplete(candidate, confirmPassword) == false) {
			return new ErrorResult("You have entered missing information. Please fill in all fields!");
		}
		
		if (checkIfIdentityNumberExists(candidate.getIdentityNumber()) == true) {
			return new ErrorResult(candidate.getIdentityNumber() + " already exists!");
		}
		
		if (checkIfEmailExists(candidate.getEmail())) {

			return new ErrorResult(candidate.getEmail() + " already exists!");
		}
		
		if (checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(),
				candidate.getLastName(), candidate.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("Identity Number could not be verified!");
		}
		
		/*if (checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(),
				candidate.getLastName(), candidate.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()) == false) {
			return new ErrorResult("Identity Number could not be verified!");
		}*/
		
		candidateService.add(candidate);
		String code = verificationService.sendCode();
		String verificationResponse = saveVerificationCodeToDb(code, userService.getByEmail(candidate.getEmail()).getData().getId(), candidate.getEmail());
		return new SuccessResult("Registration has been successfully completed! " + verificationResponse);
		
	}
	
	
	// Validation for employer register ---START---
	
	private boolean checkIfEmployerDataComplete(Employer employer) {

		if (employer.getCompanyName().isEmpty() ||
				employer.getWebsite().isEmpty() ||
				employer.getEmail().isEmpty() ||
				employer.getPhoneNumber().isEmpty() ||
				employer.getPassword().isEmpty()) {

			return false;

		}

		return true;
	}
	
	private boolean checkIfEmailMatchesDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}
	
	// Validation for employer register ---END---
	
	// Validation for candidate register ---START---
	
	private boolean checkIfCandidateDataComplete(Candidate candidate, String confirmPassword) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 

		if (candidate.getFirstName().isEmpty() || 
				candidate.getLastName().isEmpty() || 
				candidate.getIdentityNumber().isEmpty() || 
				dateFormat.format(candidate.getDateOfBirth()).isEmpty() || 
				candidate.getPassword().isEmpty() || 
				candidate.getEmail().isEmpty() ||
				confirmPassword.isEmpty()) 
		{
			return false;
		}

		return true;
	}
	
	private boolean checkIfIdentityNumberExists(String identityNumber) {

		if (candidateService.getByIdentityNumber(identityNumber).getData() != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, int birthYear) {

		if (validationService.validateByMernis(identityNumber, firstName, lastName, birthYear)) {
			return true;
		}
		return false;
	}
	
	// Validation for candidate register ---END---
	
	// Common Validation
	
	private boolean checkIfEmailExists(String email) {

		if (this.userService.getByEmail(email).getData() != null) {

			return true;
		}

		return false;
	}

	private boolean checkIfPasswordAndConfirmPasswordMatches(String password, String confirmPassword) {

		if (password.equals(confirmPassword)) {
			return true;
		}

		return false;
	}
	
	private String saveVerificationCodeToDb(String code, int userId, String email) {
		
		VerificationCode verificationCode = new VerificationCode(userId, code, false, LocalDate.now());
		verificationCodeService.add(verificationCode);
		return ("Verification code has been sent to " + email );	
	}

}
