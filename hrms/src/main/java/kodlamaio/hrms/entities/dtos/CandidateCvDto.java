package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CandidateCvDto {
//I used CV Dtos in here because of candidate has a lists of candidate's CV information in itself.
	
    private int id;
    private String firstName;
    private String lastName;
	private String coverLetter;
	private String schoolName;
	private String department;
	private String degree;
	private Date startDate;
	private Date endDate;
	private String institution;
	private String role;
	private Date jobStartDate;
	private Date jobEndDate;
	private String languageName;
	private String languageLevel;
	private String knownTechnology;
	private String webLink;
    //i used class we used in candidate class because of we must take real variable(cv information) from candidate 
//    private CandidateWebAddress candidateWebAddress;
//    private CandidateEducationInformation educationInformation;
//    private CandidateExperienceInformation experienceInformation;
//    private CandidateLanguegeLevel languageLevel;
//    private CandidateTalentInformation talentInformation;
//    private CandidateCoverLetter coverLetter;
	
//	


	
	
	

}
