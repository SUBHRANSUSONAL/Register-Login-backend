package com.Registration.Form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Authorized Signer Information Entity Repository for Creating and Reading data from database
@Repository
public interface AuthorizedRepository extends JpaRepository<AuthorizedInfo,Long>{

}
