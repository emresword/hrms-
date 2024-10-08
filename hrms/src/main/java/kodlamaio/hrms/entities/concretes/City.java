package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "city_name")
	    private String cityName;
	    
	    
	    @JsonIgnore
	    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonIgnoreProperties(value= {"city"})
	    private List<JobAdvertisement> jobAdvertisements;
}
