package kodlamaio.hrms.core.utilities.verifications;

public interface VerificationService {
	
	void sendLink(String email);
	String sendCode();

}
