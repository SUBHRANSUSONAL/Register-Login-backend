package com.Registration.Form;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Test for get and post request

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegistrationRestController.class)
public class RegistrationRestControllerTestMokito {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RegistrationRepository registrationRepo;

	@MockBean
	private BusinessRepository businessRepo;
	
	@MockBean
	private AuthorizedRepository authorizedRepo;

	//Test for Retrieve registration details by user id for the get request	
	@Test
	public void retrieveRegistrationByIdTest() throws Exception {
		Registration mockRegistration = new Registration((long) 1, "Subhransu","Sonal","Sonalsubhransu@gmail.com","INT","Sonal", null, null, null, 0, null, null);
		Optional<Registration> find=registrationRepo.findById(Mockito.anyLong());
		Mockito.when(find).thenReturn(Optional.of(mockRegistration));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registration/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{id:1,firstName:Subhransu,lastName:Sonal,userName:Sonalsubhransu@gmail.com,companyName:INT,password:Sonal}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	//Test for Retrieve registration details by userName for the get request	
	@Test
	public void retrieveRegistrationByUserNameTest() throws Exception {
		Registration mockRegistration = new Registration((long) 1, "Subhransu","Sonal","Sonalsubhransu@gmail.com","INT","Sonal", null, null, null, 0, null, null);
		Optional<Registration> find=registrationRepo.findByUserName(Mockito.anyString());
		Mockito.when(find).thenReturn(Optional.of(mockRegistration));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registrationByEmail/Sonalsubhransu@gmail.com").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{id:1,firstName:Subhransu,lastName:Sonal,userName:Sonalsubhransu@gmail.com,companyName:INT,password:Sonal}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	//Test for creating new registration details for new user for the post request	
	@Test
	public void createRegistrationTest() throws Exception {
		Registration mockRegistration = new Registration((long) 1, "Subhransu","Sonal","Sonalsubhransu@gmail.com","INT","Sonal", null, null, null, 0, null, null);
		String registrationJson = "{\"id\":\"1\",\"firstName\":\"Subhransu\",\"lastName\":\"Sonal\",\"userName\":\"Sonalsubhransu@gmail.com\",\"companyName\":\"INT\",\"password\":\"Sonal\"}";
		Mockito.when(registrationRepo.save(Mockito.any(Registration.class))).thenReturn(mockRegistration);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/registration").accept(MediaType.APPLICATION_JSON).content(registrationJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals("http://localhost/registration/1", response.getHeader(HttpHeaders.LOCATION));
		
	}	
	
}
