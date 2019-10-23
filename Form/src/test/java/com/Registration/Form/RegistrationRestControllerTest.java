package com.Registration.Form;


import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationRestControllerTest {

	//Test for creating registration details for new user for the post request	
	@Test
	@DirtiesContext
	public void PostRegistrationData() {
		String url="http://localhost:8080/registration";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Registration registration=new Registration((long) 1, "Subhransu","Sonal","Sonalsubhransu@gmail.com","INT","Sonal", null, null, null, 0, null, null);
		HttpEntity<Registration> entity = new HttpEntity<Registration>(registration, headers);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/registration/"));
	}

	//Test for creating business information details for registered user by their user id for the post request	
	@Test
	@DirtiesContext
	public void PostBusinessInfoData() {
		String url="http://localhost:8080/registration/1/business";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		BusinessInfo business=new BusinessInfo("INT","ABCDEFT45","BL","123467","8765456789","INDUSNET.CO.IN",new Date(2019-03-23), "India","Bihar","Gaya","Bihar","Gaya");
		HttpEntity<BusinessInfo> entity = new HttpEntity<BusinessInfo>(business, headers);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/registration/1/business/"));
	}
	
	//Test for creating authorized information details for registered user by their user id for the post request	
	@Test
	@DirtiesContext
	public void PostAuthorizedInfoData() {
		String url="http://localhost:8080/registration/1/authorized";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		AuthorizedInfo authorized=new AuthorizedInfo("Subhransu","Sonal","BL","India","Bihar","Gaya","123456",new Date(1996-03-23));
		HttpEntity<AuthorizedInfo> entity = new HttpEntity<AuthorizedInfo>(authorized, headers);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/registration/1/authorized/"));
	}
	
	
	
}
