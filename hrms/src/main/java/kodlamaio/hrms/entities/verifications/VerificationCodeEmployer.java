package kodlamaio.hrms.entities.verifications;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verification_code_employers")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class VerificationCodeEmployer extends VerificiationCode{
	@OneToOne
	@JoinColumn(name = "employer_id")
	 @ToString.Exclude
	private Employer employer;
	

}
