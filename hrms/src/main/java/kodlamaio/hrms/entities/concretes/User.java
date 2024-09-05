package kodlamaio.hrms.entities.concretes;

//you must import correct files
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Email(message = "Please enter a valid e-mail address.")
    @NotNull(message = "The e-mail field cannot be null.")
    @NotBlank(message = "The e-mail field cannot be blank.")
    @Column(name = "email")
    private String email;

    @NotNull(message = "The password field cannot be null.")
    @NotBlank(message = "The password field cannot be blank.")
    @Column(name = "password")
    private String password;
    
   

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Employer employer;
}
//@Entity
//@Table(name="users")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonIgnoreProperties({"hibarnatelazyInitilizer","handler","employers"})
//public class User {
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//	
//	@Email(message = "Please enter a valid e-mail address.")
//  @NotNull(message = "The e-mail field cannot be null.")
//  @NotBlank(message = "The e-mail field cannot be blank.")
//	@Column(name="email")
//	private String email;
//	
//	@NotNull(message = "The password field cannot be null.")
//  @NotBlank(message = "The password field cannot be blank.")
//	@Column(name="password")
//	private String password;
//	 
////	@OneToMany(mappedBy = "user")
////	private List<Employer> employers;
//  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//  private Employer employer;
//
//	
//
//
//
//
//}
