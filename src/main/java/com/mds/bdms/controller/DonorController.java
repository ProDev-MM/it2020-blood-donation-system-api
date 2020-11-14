package com.mds.bdms.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.bdms.constant.GlobalConstant;
import com.mds.bdms.entity.Donor;
import com.mds.bdms.entity.DonorRecord;
import com.mds.bdms.pojo.DonorPojo;
import com.mds.bdms.response.BaseResponse;
import com.mds.bdms.service.DonorRecordService;
import com.mds.bdms.service.DonorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DonorController {
    @Autowired
   DonorService donorService;

    @Autowired
    DonorRecordService donorRecordService;

    @GetMapping(value = "/donors")
    public BaseResponse getDonor(){
        List<Donor> donor;
        try{
            donor= donorService.getDonor();
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, donor, GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @GetMapping(value="/donor/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Donor donor;
        try{
            donor = donorService.findById(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, donor, GlobalConstant.Message.SUCCESS_MESSAGE);
    }



    @PostMapping (value = "/donor")
    public Donor createDonor(@RequestBody Donor donor){

            Collection<DonorRecord>donorRecords = donor.getDonorRecords();
        if(donorRecords !=null){
            donorRecords = donorRecordService.saveAll(donorRecords);
        }

        for(DonorRecord donorRecord : donorRecords){
            donor.addDonorRecord(donorRecord);
        }

        return donorService.save(donor);

    }

    @DeleteMapping(value="/donor/{id}")
    public BaseResponse deleteDonor(@PathVariable Long id){
        try {
            donorService.deleteDonor(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, null, GlobalConstant.Message.SUCCESS_MESSAGE);

    }

    @PutMapping (value = "/donor")
    public BaseResponse updateDonor(@RequestBody DonorPojo donorPojo) {
       Donor donors;

        try{
            Donor donor = donorService.findById(donorPojo.getId());

            if(donor==null) {
                return null;
            }
            donor.setName(donorPojo.getName());
        	donor.setGender(donorPojo.getGender());
        	donor.setBloodType(donorPojo.getBloodType());
        	donor.setDateOfBirth(donorPojo.getDateOfBirth());
        	donor.setAddress(donorPojo.getAddress());
        	donor.setMainPhone(donorPojo.getMainPhone());
        	donor.setHomePhone(donorPojo.getHomePhone());
        	donor.setRegisterDate(donorPojo.getRegisterDate());
        	donor.setLastDonationDate(donorPojo.getLastDonationDate());
        	donors=donorService.save(donor);

        }catch(Exception e) {
           System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }

        return new BaseResponse(GlobalConstant.SUCCESS, donors,GlobalConstant.Message.SUCCESS_MESSAGE);

    }
}
