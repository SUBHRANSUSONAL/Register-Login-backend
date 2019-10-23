package com.Registration.Form;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//Fetch data from cross origin site like React which runs at port 3000
@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class RegistrationRestController {

	//Registration Repository autowired for CRUD methods
	@Autowired
	private RegistrationRepository registrationRepo;
	
	//Business Repository autowired for CRUD methods
	@Autowired
	private BusinessRepository businessRepo;
	
	//Authorized Repository autowired for CRUD methods
	@Autowired
	private AuthorizedRepository authorizedRepo;
	
	//save data of registration entity in the database using save method of crud repository
	@PostMapping("/registration")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Registration registration) {
		Registration savedUser=registrationRepo.save(registration);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//save data of business information entity in the database using save method of crud repository and find by id for registration entity
	@PostMapping("/registration/{id}/business")
	public ResponseEntity<Object> createBusiness(@PathVariable long id,@Valid @RequestBody BusinessInfo businessInfo) {
		Optional<Registration> userOptional = registrationRepo.findById(id);
		if(!userOptional.isPresent())
        {
        	throw new ResourseNotFoundException();
        }
		Registration user= userOptional.get();
		businessInfo.setRegistration(user);
		businessRepo.save(businessInfo);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(businessInfo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//save data of authorized signer information entity in the database using save method of crud repository and find by id for registration entity
	@PostMapping("/registration/{id}/authorized")
	public ResponseEntity<Object> createAuthorized(@PathVariable long id,@Valid @RequestBody AuthorizedInfo authorizedInfo) {
		Optional<Registration> userOptional = registrationRepo.findById(id);
		if(!userOptional.isPresent())
        {
        	throw new ResourseNotFoundException();
        }
		Registration user= userOptional.get();
		authorizedInfo.setRegistration(user);
		authorizedRepo.save(authorizedInfo);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(authorizedInfo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//check the login credentials in the registration entity by using crud method find by user name and password
	@PostMapping("/login")
	public Registration checkLogin(@RequestBody Registration registration){
		Optional<Registration> userOptional=registrationRepo.findByUserNameAndPassword(registration.getUserName(),registration.getPassword());
		if(!userOptional.isPresent())
        {
        	throw new ResourseNotFoundException();
        }
		return registration;
	}
	
	//retrieve registration entity details by using find by id method for get mapping
	@GetMapping("/registration/{id}")
	public Optional<Registration> retrieveUser(@PathVariable long id) {
		Optional<Registration> find=registrationRepo.findById(id);
		if(!find.isPresent())
        {
        	throw new ResourseNotFoundException();
        }
		 return find;
	}
		
	//retrieve registration entity details by username which is email
	@GetMapping("/registrationByEmail/{email}")
	public Optional<Registration> retrieveUserEmail(@PathVariable String email) {
		Optional<Registration> find=registrationRepo.findByUserName(email);
		if(!find.isPresent())
        {
        	throw new ResourseNotFoundException();
        }
		 return find;
	}

	//update active column of registration entity to 1 which is 0 by default to verify the user's account
	@PutMapping("/registration/{id}")
	public Registration updateActive(@PathVariable("id") Long id,@RequestBody Registration registration) {
		Registration active=registrationRepo.findById(id).orElseThrow(()->new ResourseNotFoundException());
	    active.setActive(1);
	    Registration updatedActive=registrationRepo.save(active);
	    return updatedActive;
	    	
	}
		
}
