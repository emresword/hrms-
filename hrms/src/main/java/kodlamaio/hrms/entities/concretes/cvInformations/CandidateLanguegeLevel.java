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

@Entity
@Table(name = "candidate_language_levels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLanguegeLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "language_name")
	private String languageName;
	@Column(name = "language_level")
	private String languageLevel;
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnoreProperties(value = { "candidateLanguegeLevel" })

	private Candidate candidate;
}
