package kodlamaio.hrms.business.requests;

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
public class CreateCandidateRequest {
	@NotBlank
	private String email;
	
    @NotBlank
    private String password;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Size(min = 11, max = 11)
	private String identityNumber;
	
    @NotNull
	private Date birthYear;
}
