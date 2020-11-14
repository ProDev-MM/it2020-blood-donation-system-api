package com.mds.bdms.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.bdms.entity.DonorRecord;
import com.mds.bdms.repository.DonorRecordRepository;

@Service
public class DonorRecordService {
    @Autowired
    DonorRecordRepository donorRecordRepository;

    public List<DonorRecord> getDonorRecord() {
        return donorRecordRepository.findAll();
    }

    public DonorRecord findById(Long id) {
        return donorRecordRepository.findById(id).orElse(null);
    }

    public DonorRecord addDonorRecord(DonorRecord donorRecord) {
        return donorRecordRepository.save(donorRecord);
    }

    public void deleteDonorRecord(Long id) {
      donorRecordRepository.deleteById(id);
    }

    public DonorRecord save(DonorRecord donorRecord) {
        return donorRecordRepository.save(donorRecord);
    }

    public Collection<DonorRecord> saveAll(Collection<DonorRecord> donorRecords) {
        return  donorRecordRepository.saveAll(donorRecords);
    }
}

