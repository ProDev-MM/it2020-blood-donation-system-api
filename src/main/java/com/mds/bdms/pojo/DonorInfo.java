package com.mds.bdms.pojo;

public class DonorInfo {
	Long id;
	String name;
	String address;
	String bloodType;
	String mainPhone;
	String homePhone;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
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
	public DonorInfo(Long id, String name, String address, String bloodType, String mainPhone, String homePhone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.bloodType = bloodType;
		this.mainPhone = mainPhone;
		this.homePhone = homePhone;
	}
	

}
