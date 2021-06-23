package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import kodlamaio.hrms.core.entities.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdDetailsDto implements Dto{
	
	private int id;
	private String companyName;
	private String jobTitle;
	private int openPositionQty;
	private LocalDate publishedAt;
	private LocalDate deadline;
	private boolean isActive;

}
