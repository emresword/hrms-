package kodlamaio.hrms.entities.concretes.cvInformations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "candidate_web_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWebAddress {
	@Id
	@Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "web_link")
	private String webLink;

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnoreProperties(value = { "candidateWebAddresses" })
	
	private Candidate candidate;
}
