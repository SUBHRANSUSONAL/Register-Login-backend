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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//Entity class for storing Registration data for new user
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
	@Column(unique=true)
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
    @CreationTimestamp
    private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
	
	private int active=0;
	
	//Foreign key in Business Information table
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="registration")
	private BusinessInfo businessInfo;
	
	//Foreign key in Authorized Signer Information table
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="registration")
	private AuthorizedInfo authorizedInfo;


	public Registration(Long id, @NotNull @Size(max = 25) String firstName, @NotNull @Size(max = 25) String lastName,
			@NotNull @Email @Size(max = 50) String userName, @NotNull @Size(max = 25) String companyName,
			@NotNull @Size(max = 25) String password, Long code, Date createdAt, Date updatedAt, int active,
			BusinessInfo businessInfo, AuthorizedInfo authorizedInfo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.companyName = companyName;
		this.password = password;
		this.code = code;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.active = active;
		this.businessInfo = businessInfo;
		this.authorizedInfo = authorizedInfo;
	}

	public AuthorizedInfo getAuthorizedInfo() {
		return authorizedInfo;
	}

	public void setAuthorizedInfo(AuthorizedInfo authorizedInfo) {
		this.authorizedInfo = authorizedInfo;
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
