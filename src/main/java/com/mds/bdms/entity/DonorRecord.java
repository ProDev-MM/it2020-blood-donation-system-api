package com.mds.bdms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DONOR_RECORD")
@SequenceGenerator(name="seq",initialValue=1,allocationSize=100)
public class DonorRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq")
    Long id;
    
    @Column
    LocalDate donationDate;
    
    @Column(name="DONOR_ID")
    private Long donorId;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDonationDate() {
        return donationDate;
    }
    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public Long donorId() {
        return donorId;
    }
    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }
	@Override
	public String toString() {
		return "DonorRecord [id=" + id + ", donationDate=" + donationDate + ", donorId=" + donorId + "]";
	}
	
    

}
