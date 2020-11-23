package com.mds.bdms.service;

import com.mds.bdms.entity.Donor;
import com.mds.bdms.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }

    public Donor save(Donor donor) {
        return donorRepository.save(donor);
    }
    
    public List<Donor> findByName(String name) {
        return donorRepository.findByName(name);
    }
    
    public List<Donor> findByMainPhone(String mainPhone) {
        return donorRepository.findByMainPhone(mainPhone);
    }
    
    
    public List<Donor>findByBloodType(String bloodType){
    return donorRepository.findByBloodType(bloodType);
    	
    }
    public List<Donor>findByNameorGender(String name,String gender){
        return donorRepository.findByNameorGender(name,gender);
        	
        }
    

   
}
