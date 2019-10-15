package com.Registration.Form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{

	@Query(value="SELECT * FROM registration r where r.id=:id and r.active=1",nativeQuery=true)
	Registration findByActive(@Param("id") Long id);

}
