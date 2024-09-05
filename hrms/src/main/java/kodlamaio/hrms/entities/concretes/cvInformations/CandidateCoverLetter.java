package kodlamaio.hrms.entities.concretes.cvInformations;

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
@Table(name = "candidate_cover_letters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCoverLetter {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cover_letter")
	private String coverLetter;
	// candidate ile tüm cv bilgileri bağlanmalı

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnoreProperties(value = { "candidateCoverLetter" })
    private Candidate candidate;
}
