package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
	//*** class da kulanılan atribute isimleri metot isimlerinde kullanılıyor bu baya önemli
	//örnegin employerda userıd yok user kullanıcaz
	Employer getByPhoneNumber(String phoneNumber);
	Employer getById(int id);
	List<Employer> getByIdIn(List<Integer> userIds);//
	List<Employer> getByPhoneNumberContains(String phoneNumber);
	List<Employer> getByPhoneNumberStartsWith(String phoneNumber);
	//user.id ancak burda employerphonenumber yazabiliriz çünkü queryle veri alıcaz
	//***query içindeki ilk değer classtaki değer diğeri ise parametre içindeki 
	@Query("From Employer where phoneNumber=:phoneNumber and id=:userId")
	Employer getByEmployerPhoneNumberAndUserId(@Param("phoneNumber")String phoneNumber,@Param("userId")int userId);
	boolean existsByEmail(String email);
	
	@Query("SELECT new kodlamaio.hrms.entities.dtos.EmployerDto("
	        + "e.id, e.email, e.password, e.companyName, e.webAddress, e.phoneNumber, "
	        + "job.jobDescription, job.minSalary,job.jobPositionCount, job.maxSalary,  job.applicationStart, job.applicationDeadLine) "
	        + "FROM Employer e inner join e.jobAdvertisements job")
	List<EmployerDto> getAllEmployerWithDetails();

	
	
	@Query("From Employer e inner join e.verificationCodeEmployer ver where ver.isVerified =true ")
	List<Employer> getAllActiveEmployer();
	

	
}
