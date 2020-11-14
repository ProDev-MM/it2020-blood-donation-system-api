package com.mds.bdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.bdms.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

}
