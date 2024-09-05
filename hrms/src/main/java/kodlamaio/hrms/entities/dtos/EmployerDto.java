package kodlamaio.hrms.entities.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
    private int id;
    private String email;
    private String password;
    private String companyName;
    private String webAddress;
    private String phoneNumber;
    private String jobDescription;
    private double minSalary;
    private int jobPositionCount;
    private double maxSalary;
    private Date applicationStart;
    private Date applicationDeadLine;
}
