package kodlamaio.hrms.entities.concretes.cvInformations;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "candidate_education_informations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEducationInformation {
	@Id
	@Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "school_name")
	private String schoolName;
	@Column(name = "department")
	private String department;
	@Column(name = "degree")
	private String degree;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @JsonIgnoreProperties(value = { "candidateEducationInformation"})
  
    private Candidate candidate;
    //jsonıgnoreproperties json formatında bu verilerin istenmesine yardımcı oluyo
}
