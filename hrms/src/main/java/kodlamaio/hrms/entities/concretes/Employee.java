package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.confirms.EmployeeConfirms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employee extends User {

	@NotBlank(message = "firstName cannot be blank")
	@NotNull(message = "firstName cannot be null")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "lastName cannot be blank")
	@NotNull(message = "lastName cannot be null")
	@Column(name = "last_name")
	private String lastName;

//	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	 @JoinColumn(name = "id")
//	 @JsonIgnore
//	 private User user;  
	// extend den kaynaklı buna gerek yok

	@OneToOne(mappedBy = "employee")

	@JsonIgnoreProperties(value = { "employee" })
	@ToString.Exclude
	private EmployeeConfirms employeeConfirms;

}
