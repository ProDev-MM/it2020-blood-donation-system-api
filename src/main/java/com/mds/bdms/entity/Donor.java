package com.mds.bdms.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "donor")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
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
    
   
    public Donor(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
    public String toString() {
        return "Donor [id=" + id + ", name=" + name + ", gender=" + gender + ", bloodType=" + bloodType
                + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", mainPhone=" + mainPhone + ", homePhone="
                + homePhone + ", registerDate=" + registerDate + ", lastDonationDate=" + lastDonationDate
                + ", donorRecords=" + "]";
    }

}
