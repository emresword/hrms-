package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.cvInformations.CandidateCoverLetter;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateEducationInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateExperienceInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateImageInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateLanguegeLevel;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateTalentInformation;
import kodlamaio.hrms.entities.concretes.cvInformations.CandidateWebAddress;
import kodlamaio.hrms.entities.verifications.VerificationCodeCandidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id") // There is no need for this thanks to the extension we
																// made from the user.

public class Candidate extends User {

	@NotBlank(message = "firstName cannot be blank")
	@NotNull(message = "firstName cannot be null")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "lastName cannot be blank")
	@NotNull(message = "lastName cannot be null")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "identityNumber cannot be blank")
	@NotNull(message = "identityNumber cannot be null")
	@Pattern(regexp = "\\d{11}", message = "identity number must be 11 characters")
	@Column(name = "identity_number", unique = true)
	private String identityNumber;

	@NotBlank(message = "birthYear cannot be blank")
	@NotNull(message = "birthYear cannot be null")
	@Column(name = "birth_year")
	private int birthYear;

//	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	 @JoinColumn(name = "id")
//	 @JsonIgnore
//	 private User user; 

	@OneToMany(mappedBy = "candidate", cascade =CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateWebAddress> candidateWebAddresses;

	@OneToMany(mappedBy = "candidate", cascade =CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateEducationInformation> candidateEducationInformation;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateExperienceInformation> candidateExperienceInformation;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateLanguegeLevel> candidateLanguegeLevel;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateTalentInformation> candidateTalentInformation;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateCoverLetter> candidateCoverLetter;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private List<CandidateImageInformation> candidateImageInformation;

	@OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "candidate" })
	@ToString.Exclude
	private VerificationCodeCandidate verificationCodeCandidate;
//		bunu sonra aç
	
}
