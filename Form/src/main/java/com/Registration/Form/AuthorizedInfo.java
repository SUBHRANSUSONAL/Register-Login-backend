package com.Registration.Form;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class AuthorizedInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String streetAddress;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String zipCode;
	
	private String dateOfBirth;
	
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="businessinfo_id",nullable=false)
	private BusinessInfo businessInfo;
	
	public BusinessInfo getBusinessInfo() {
		return businessInfo;
	}

	public void setBusinessInfo(BusinessInfo businessInfo) {
		this.businessInfo = businessInfo;
	}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public AuthorizedInfo(String firstName, String lastName, String streetAddress, String country, String state,
			String city, String zipCode, String dateOfBirth, BusinessInfo businessInfo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.dateOfBirth = dateOfBirth;
		this.businessInfo = businessInfo;
	}

	@Override
	public String toString() {
		return "AuthorizedInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress="
				+ streetAddress + ", country=" + country + ", state=" + state + ", city=" + city + ", zipCode="
				+ zipCode + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
}
