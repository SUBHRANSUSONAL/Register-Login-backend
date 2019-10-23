package com.Registration.Form;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Registration Entity Repository for Creating and Reading data from database
@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{
	
	//Native SQL Query to select * from registration table where active column=1 and userName=Say('Sonalsubhransu@gmail.com') and password=Say('12345')
	@Query(value="SELECT * FROM registration  where user_name=:userName and password=:password and active=1",nativeQuery=true)
	Optional<Registration> findByUserNameAndPassword(String userName,String password);
	
	//Query for find by username=say('sonalsubhransu@gmail.com')
	Optional<Registration> findByUserName(String userName);

}
