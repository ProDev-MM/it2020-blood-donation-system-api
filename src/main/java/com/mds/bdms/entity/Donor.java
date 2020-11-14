package com.mds.bdms.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="donor")
@SequenceGenerator(name="seq",initialValue=1,allocationSize=100)
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq")
    Long id;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private String bloodType;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String address;
    @Column
    private String mainPhone;
    @Column
    private String homePhone;
    @Column
    private LocalDate registerDate;
    @Column
    private LocalDate lastDonationDate;
    @OneToMany
    @JoinColumn(name="DONOR_ID")
    private Collection<DonorRecord>donorRecords;
    
    
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	
	public Collection<DonorRecord>getDonorRecords(){
		return donorRecords;
	}
	
    public void addDonorRecord(DonorRecord donorRecord) {
    	if(donorRecords==null) {
    		donorRecords=new ArrayList<DonorRecord>();
    	}
    	if(!donorRecords.contains(donorRecord)) {
    		donorRecords.add(donorRecord);
    	}
    }

	@Override
	public String toString() {
		return "Donor [id=" + id + ", name=" + name + ", gender=" + gender + ", bloodType=" + bloodType
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", mainPhone=" + mainPhone + ", homePhone="
				+ homePhone + ", registerDate=" + registerDate + ", lastDonationDate=" + lastDonationDate
				+ ", donorRecords=" + donorRecords + "]";
	}
	
}
