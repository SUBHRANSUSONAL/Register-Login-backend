package com.Registration.Form;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;



@Entity
public class Registration {

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
	@Email
	@Size(max=50)
	private String userName;
	
	@NotNull
	@Size(max=25)
	private String companyName;
	
	@NotNull
	@Size(max=25)
	private String password;
	
	private Long code;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;
	
	private int active=0;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="registration")
	private BusinessInfo businessInfo;
	
	

	public Registration( @NotNull @Size(max = 25) String firstName, @NotNull @Size(max = 25) String lastName,
			@NotNull @Email @Size(max = 50) String userName, @NotNull @Size(max = 25) String companyName,
			@NotNull @Size(max = 25) String password, Long code, Date createdAt, int active,
			BusinessInfo businessInfo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.companyName = companyName;
		this.password = password;
		this.code = code;
		this.createdAt = createdAt;
		this.active = active;
		this.businessInfo = businessInfo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public BusinessInfo getBusinessInfo() {
		return businessInfo;
	}

	public void setBusinessInfo(BusinessInfo businessInfo) {
		this.businessInfo = businessInfo;
	}

	protected Registration() {}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", companyName=" + companyName + ", password=" + password + ", code=" + code
				+ ", createdAt=" + createdAt + ", active=" + active + ", businessInfo=" + businessInfo + "]";
	}


	
	
}
