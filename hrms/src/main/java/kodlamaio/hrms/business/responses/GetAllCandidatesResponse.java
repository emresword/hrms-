package kodlamaio.hrms.business.responses;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCandidatesResponse {

	private int id;

	private String email;

	private String firstName;

	private String lastName;

	private String identityNumber;

	private Date birthYear;
}
