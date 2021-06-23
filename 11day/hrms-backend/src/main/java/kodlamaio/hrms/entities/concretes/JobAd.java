package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_ads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAd implements kodlamaio.hrms.core.entities.Entity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_qty")
	private int openPositionQty;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "published_at")
	private LocalDate publishedAt;

	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "working_type_id")
	private WorkingType workingType;
	
	@ManyToOne
	@JoinColumn(name = "working_time_id")
	private WorkingType workingTime;

}
