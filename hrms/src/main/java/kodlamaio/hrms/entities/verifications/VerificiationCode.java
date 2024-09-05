package kodlamaio.hrms.entities.verifications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "verification_codes")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class VerificiationCode {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "code",nullable = false)
	private String code;
	@NotNull
	@Column(name = "is_verified",nullable = false)
	private boolean isVerified = false;

	@Column(name = "verified_date")
	private Date verifiedDate;

}
