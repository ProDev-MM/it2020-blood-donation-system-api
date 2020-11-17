package com.mds.bdms.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.mds.bdms.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {
	@Query(value="Select  d.id,d.name,d.bloodType,d.address,d.mainPhone,d.homePhone from Donor  d where d.bloodType=:bloodType")
	  List<Object[]>findByBloodType(@Param("bloodType") String bloodType);
}
    