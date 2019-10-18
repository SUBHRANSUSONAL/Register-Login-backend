package com.Registration.Form;

import java.net.URI;
import java.util.List;
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




@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class RegistrationRestController {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	@Autowired
	private BusinessRepository businessRepo;
	
	@Autowired
	private AuthorizedRepository authorizedRepo;
	
	@PostMapping("/registration")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Registration registration) {
		Registration savedUser=registrationRepo.save(registration);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/registration/{id}/business")
	public ResponseEntity<Object> createBusiness(@PathVariable long id, @RequestBody BusinessInfo businessInfo) {
		Optional<Registration> userOptional = registrationRepo.findById(id);
		
		Registration user= userOptional.get();
		
		businessInfo.setRegistration(user);
		businessRepo.save(businessInfo);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(businessInfo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/registration/{id}/authorized")
	public ResponseEntity<Object> createAuthorized(@PathVariable long id, @RequestBody AuthorizedInfo authorizedInfo) {
		Optional<Registration> userOptional = registrationRepo.findById(id);
		
		Registration user= userOptional.get();
		
		authorizedInfo.setRegistration(user);
		authorizedRepo.save(authorizedInfo);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(authorizedInfo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/login")
	public Registration checkLogin(@RequestBody Registration registration){
		Optional<Registration> userOptional=registrationRepo.findByUserNameAndPassword(registration.getUserName(),registration.getPassword());
		if(!userOptional.isPresent())
        {
        	throw new ResourseNotFoundException();
        }
	
		return registration;
	}
	
	@GetMapping("/registration/{id}")
	public Optional<Registration> retrieveUser(@PathVariable long id) {
		Optional<Registration> find=registrationRepo.findById(id);
		 return find;
	}
	
	@GetMapping("/login")
	public List<Registration> retrieveUserByActive() {
		return registrationRepo.findByActive();
	}
	
	
	@PutMapping("/registration/{id}")
	public Registration updateActive(@PathVariable("id") Long id,@RequestBody Registration registration) {
		Registration active=registrationRepo.findById(id).orElseThrow(()->new ResourseNotFoundException());
	    	
	    active.setActive(1);
	    
	    Registration updatedActive=registrationRepo.save(active);
	    return updatedActive;
	    	
	}
	
	@GetMapping("/registrationByEmail/{email}")
	public Registration retrieveUserEmail(@PathVariable String email) {
		Registration find=registrationRepo.findByUserName(email);
		 return find;
	}
		

		
}
