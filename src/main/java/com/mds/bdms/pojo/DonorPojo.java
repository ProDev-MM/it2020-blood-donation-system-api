package com.mds.bdms.pojo;

import java.time.LocalDate;

public class DonorPojo {

	Long id;
	String name;
	String gender;
	String bloodType;
	LocalDate dateOfBirth;
	String address;
	String mainPhone;
	String homePhone;
	LocalDate registerDate;
	LocalDate lastDonationDate;
	
	
	
	public DonorPojo(Long id, String name, String gender,String bloodType,String address,LocalDate dateOfBirth
			,String mainPhone,String homePhone,LocalDate registerDate,LocalDate lastDonationDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender=gender;
		this.bloodType=bloodType;
		this.address=address;
		this.dateOfBirth=dateOfBirth;
		this.mainPhone=mainPhone;
		this.homePhone=homePhone;
		this.registerDate=registerDate;
		this.lastDonationDate=lastDonationDate;
		
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMainPhone() {
		return mainPhone;
	}
	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public LocalDate getLastDonationDate() {
		return lastDonationDate;
	}
	public void setLastDonationDate(LocalDate lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}
	
	
	 
}
