package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import kodlamaio.hrms.core.entities.Dto;

public class UserForLoginDto implements Dto {
	
	private String email;
    private String password;
    private LocalDate publishedAt;

}
