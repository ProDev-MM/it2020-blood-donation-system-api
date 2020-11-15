package com.mds.bdms.pojo;

import java.time.LocalDate;

public class DonorRecordPojo {
	Long id;
	LocalDate donationDate;
	Long donorId;

	public DonorRecordPojo() {
	}

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
	public Long getDonorId() {
		return donorId;
	}
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

	@Override
	public String toString() {
		return "DonorRecordPojo{" +
				"id=" + id +
				", donationDate=" + donationDate +
				", donorId=" + donorId +
				'}';
	}
}
