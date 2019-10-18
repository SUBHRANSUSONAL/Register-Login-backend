package com.Registration.Form;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{

	@Query(value="SELECT * FROM registration r where r.active=1",nativeQuery=true)
	List<Registration> findByActive();
	
	@Query(value="SELECT * FROM registration  where user_name=:userName and password=:password and active=1",nativeQuery=true)
	Optional<Registration> findByUserNameAndPassword(String userName,String password);
	
	Registration findByUserName(String userName);

}
