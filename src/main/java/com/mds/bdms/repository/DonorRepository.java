package com.mds.bdms.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mds.bdms.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {
	
	@Query(value="Select d from Donor  d where d.bloodType=:bloodType")
	  List<Donor>findByBloodType(String bloodType);
	
	
	@Query(value="Select d from Donor  d where d.name=:name")
	 List<Donor> findByName(String name);
	
	@Query(value="Select d from Donor  d where d.mainPhone=:mainPhone")
	  List<Donor>findByMainPhone(String mainPhone);
	
	@Query(value="Select d from Donor d where d.name=:name  or d.gender=:gender")
	 List<Donor>findByNameorGender(String name,String gender);
	
}