package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LocationType;

public interface LocationTypeDao extends JpaRepository<LocationType, Integer>{

}
