package com.Registration.Form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Business Information Entity Repository for Creating and Reading data from database
@Repository
public interface BusinessRepository extends JpaRepository<BusinessInfo,Long>{

	
}
