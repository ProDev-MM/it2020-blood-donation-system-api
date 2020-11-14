package com.mds.bdms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.bdms.entity.Donor;
import com.mds.bdms.repository.DonorRepository;

@Service
public class DonorService {
    @Autowired
    DonorRepository donorRepository;

    public List<Donor> getDonor() {
        return donorRepository.findAll();
    }

    public Donor findById(Long id) {
        return donorRepository.findById(id).orElse(null);
    }

    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }

    public Donor save(Donor donor) {
        return donorRepository.save(donor);
    }
}
