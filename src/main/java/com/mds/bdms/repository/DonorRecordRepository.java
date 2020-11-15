package com.mds.bdms.repository;

import com.mds.bdms.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.bdms.entity.DonorRecord;

import java.util.List;

public interface DonorRecordRepository extends JpaRepository<DonorRecord,Long>{
    List<DonorRecord> findAllByDonor(Donor donor);
}
