package com.Registration.Form;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

//Entity class for storing Authorized Signer Information data
@Entity
public class AuthorizedInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max=25)
	private String firstName;
	
	@NotNull
	@Size(max=25)
	private String lastName;
	
	@NotNull
	@Size(max=25)
	private String streetAddress;
	
	@NotNull
	private String country;
	
	@NotNull
	private String state;
	
	@NotNull
	private String city;
	
	@NotNull
	@Size(min=6,max=6)
	private String zipCode;
	
	@NotNull
	@Past
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	//One To One Mapping with Registration table
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="registration_id",nullable=false)
	private Registration registration;

	protected AuthorizedInfo() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public AuthorizedInfo(String firstName, String lastName, String streetAddress, String country, String state,
			String city, String zipCode, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.dateOfBirth = dateOfBirth;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "AuthorizedInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress="
				+ streetAddress + ", country=" + country + ", state=" + state + ", city=" + city + ", zipCode="
				+ zipCode + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
}
