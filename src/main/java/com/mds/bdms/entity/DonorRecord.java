package com.mds.bdms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class DonorRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    LocalDate donationDate;
    @OneToOne
    private Donor donor;

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

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    @Override
    public String toString() {
        return "DonorRecord [id=" + id + ", donationDate=" + donationDate + ", donorId=" + donor + "]";
    }


}
