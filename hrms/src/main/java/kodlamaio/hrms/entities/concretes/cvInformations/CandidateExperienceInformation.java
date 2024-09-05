package kodlamaio.hrms.entities.concretes.cvInformations;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.enums.StorageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name ="candidate_experience_informations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateExperienceInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "institution")
	private String institution;
	@Column(name = "role")
	private String role;
	@Column(name = "job_start_date")
	private Date jobStartDate;
	@Column(name = "job_end_date")
	private Date jobEndDate;
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnoreProperties(value = {"candidateExperienceInformation"})
	private Candidate candidate;
}
