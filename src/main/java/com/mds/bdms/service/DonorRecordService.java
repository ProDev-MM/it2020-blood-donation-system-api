package com.mds.bdms.service;

import com.mds.bdms.entity.Donor;
import com.mds.bdms.entity.DonorRecord;
import com.mds.bdms.pojo.DonorRecordPojo;
import com.mds.bdms.repository.DonorRecordRepository;
import com.mds.bdms.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DonorRecordService {
    @Autowired
    DonorRecordRepository donorRecordRepository;
    @Autowired
    DonorRepository donorRepository;

    public DonorRecord findById(Long id) {
        return donorRecordRepository.findById(id).orElse(null);
    }

    public List<DonorRecord> getDonorRecord() {
        return donorRecordRepository.findAll();
    }

    public List<DonorRecord> getRecordByDonorId(long donorId) {
        Optional<Donor> donor = donorRepository.findById(donorId);
        if (donor.isPresent()) {
            return donorRecordRepository.findAllByDonor(donor.get());
        } else {
            throw new EntityNotFoundException("Donor Not Found");
        }
    }

    public DonorRecord addDonorRecord(DonorRecordPojo donorRecordPojo) {

        System.out.println(donorRecordPojo);

        Optional<Donor> optionalDonor = donorRepository.findById(donorRecordPojo.getDonorId());
        if (!optionalDonor.isPresent()) {
            throw new EntityNotFoundException("Donor Not Found");
        }

        System.out.println(optionalDonor.get());

        // save donorRecord
        DonorRecord donorRecord = new DonorRecord();
        donorRecord.setDonationDate(donorRecordPojo.getDonationDate());
        donorRecord.setDonor(optionalDonor.get());
        donorRecord = donorRecordRepository.save(donorRecord);

        // update lastDonationDate of particular donor
        Donor donor = optionalDonor.get();
        donor.setLastDonationDate(donorRecordPojo.getDonationDate());
        donorRepository.save(donor);

        return donorRecord;
    }

    public void deleteDonorRecord(Long id) {
        donorRecordRepository.deleteById(id);
    }

//    public Collection<DonorRecord> saveAll(Collection<DonorRecord> donorRecords) {
//        return  donorRecordRepository.saveAll(donorRecords);
//    }
}

