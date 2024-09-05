package kodlamaio.hrms.entities.concretes.confirms;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_confirm_employer")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class EmployeeConfirmEmployer extends EmployeeConfirms {
	@OneToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
}
