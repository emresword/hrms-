package kodlamaio.hrms.entities.verifications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity

@Table(name = "verification_code_candidates")
@Getter
@Setter
public class VerificationCodeCandidate extends VerificiationCode {

	@OneToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnoreProperties(value = { "verificationCodeCandidate" })
	@ToString.Exclude
	private Candidate candidate;

}
