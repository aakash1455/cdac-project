package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="hospital")
public class Hospital 
{
	private Integer hospitalId;
	private String hospitalName,password;
	private String city,region;
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("in hospital def constr");
	}

	public Hospital(Integer hospitalId, String hospitalName, String password, String city, String region) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.password = password;
		this.city = city;
		this.region = region;
	}
	
	@Id
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	@Column(length=20)
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length=20)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", password=" + password
				+ ", city=" + city + ", region=" + region + "]";
	}
	
	
	
}
