package com.Registration.Form;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

//Entity class for storing Business Information data
@Entity
public class BusinessInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max=25)
	private String companyName;
	
	@NotNull
	@Size(max=25)
	private String tax;
	
	@NotNull
	@Size(max=25)
	private String streetAddress;
	
	@NotNull
	@Size(min=6,max=6)
	private String zipCode;
	
	@NotNull
	@Size(min=10,max=10)
	private String companyPhone;
	
	@NotNull
	@Size(max=25)
	private String website;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfIncorporation;
	
	@NotNull
	private String country;
	
	@NotNull
	private String statee;
	
	@NotNull
	private String city;
	
	@NotNull
	private String stateOfInc;
	
	@NotNull
	private String cityOfInc;
	
	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	//One To One Mapping with Registration table
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="registration_id",nullable=false)
	private Registration registration;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getDateOfIncorporation() {
		return dateOfIncorporation;
	}

	public void setDateOfIncorporation(Date dateOfIncorporation) {
		this.dateOfIncorporation = dateOfIncorporation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatee() {
		return statee;
	}

	public void setStatee(String statee) {
		this.statee = statee;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOfInc() {
		return stateOfInc;
	}

	public void setStateOfInc(String stateOfInc) {
		this.stateOfInc = stateOfInc;
	}

	public String getCityOfInc() {
		return cityOfInc;
	}

	public void setCityOfInc(String cityOfInc) {
		this.cityOfInc = cityOfInc;
	}

	@Override
	public String toString() {
		return "BusinessInfo [id=" + id + ", companyName=" + companyName + ", tax=" + tax + ", streetAddress="
				+ streetAddress + ", zipCode=" + zipCode + ", companyPhone=" + companyPhone + ", website=" + website
				+ ", dateOfIncorporation=" + dateOfIncorporation + ", country=" + country + ", statee=" + statee
				+ ", city=" + city + ", stateOfInc=" + stateOfInc + ", cityOfInc=" + cityOfInc + "]";
	}


	public BusinessInfo(@NotNull @Size(max = 25) String companyName, @NotNull @Size(max = 25) String tax,
			@NotNull @Size(max = 25) String streetAddress, @NotNull @Size(max = 6) String zipCode,
			@NotNull @Size(max = 10) String companyPhone, @NotNull @Size(max = 25) String website,
			@NotNull Date dateOfIncorporation, @NotNull String country, @NotNull String statee, @NotNull String city,
			@NotNull String stateOfInc, @NotNull String cityOfInc) {
		super();
		this.companyName = companyName;
		this.tax = tax;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.companyPhone = companyPhone;
		this.website = website;
		this.dateOfIncorporation = dateOfIncorporation;
		this.country = country;
		this.statee = statee;
		this.city = city;
		this.stateOfInc = stateOfInc;
		this.cityOfInc = cityOfInc;
	}

	protected BusinessInfo() {}
	
}
