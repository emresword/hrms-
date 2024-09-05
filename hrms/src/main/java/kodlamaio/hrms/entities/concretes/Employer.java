package kodlamaio.hrms.entities.concretes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.confirms.EmployeeConfirmEmployer;
import kodlamaio.hrms.entities.concretes.confirms.EmployeeConfirms;
import kodlamaio.hrms.entities.verifications.VerificationCodeEmployer;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employers")
@Data
//if user's constructor has id we are gonna encounter with HATA: cannot insert a non-DEFAULT value into column "id"
//Ayrıntı: Column "id" is an identity column defined as GENERATED ALWAYS.
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id") // bunun sayesinde employer idsi ile user idsi
																// bağlanıyor
public class Employer extends User {

	@NotBlank(message = "companyName cannot be blank")
	@NotNull(message = "companyName cannot be null")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "webAddress cannot be blank")
	@NotNull(message = "webAddress cannot be null")
	@Column(name = "web_address")
	private String webAddress;

	@NotBlank(message = "phoneNumber cannot be blank")
	@NotNull(message = "phoneNumber cannot be null")
	@Column(name = "phone_number")
	private String phoneNumber;

	// user id si ile employer id si ni eşleştiryoruz
	// aslında employer classında userıd vardı ancak join sayesinde o entity olmadan
	// idleri eşleştirdik
	// burada id dedik bu id user tablosu içerinindeki entity dir
//	@ManyToOne()
//	@JoinColumn(name="user_id")
//	private User user;
	// one to one ı kaldırabiliriz çünkü bizden id ye göre employer getir dememişler
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//	@JsonIgnore//bunun sayesinde tekrar user atributlarını girmemize gerek kalmaz
//    private User user;
	// user_id
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "employer" })
	@ToString.Exclude
	private List<JobAdvertisement> jobAdvertisements;

	@OneToOne(mappedBy = "employer")
	private EmployeeConfirmEmployer employeeConfirmEmployer;
	
	@OneToOne(mappedBy = "employer")
	private VerificationCodeEmployer verificationCodeEmployer;
}
