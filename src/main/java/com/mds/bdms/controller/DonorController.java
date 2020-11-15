package com.mds.bdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mds.bdms.constant.GlobalConstant;
import com.mds.bdms.entity.Donor;
import com.mds.bdms.entity.DonorRecord;
import com.mds.bdms.pojo.DonorPojo;
import com.mds.bdms.response.BaseResponse;
import com.mds.bdms.service.DonorRecordService;
import com.mds.bdms.service.DonorService;

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
        DonorPojo donorPojo = new DonorPojo();
        try{
            Donor donor = donorService.findById(id);
            List<DonorRecord> donorRecords = donorRecordService.getRecordByDonorId(id);
            // donor to donorPojo
            donorPojo.setName(donor.getName());
            donorPojo.setGender(donor.getGender());
            donorPojo.setBloodType(donor.getBloodType());
            donorPojo.setDateOfBirth(donor.getDateOfBirth());
            donorPojo.setAddress(donor.getAddress());
            donorPojo.setMainPhone(donor.getMainPhone());
            donorPojo.setHomePhone(donor.getHomePhone());
            donorPojo.setRegisterDate(donor.getRegisterDate());
            donorPojo.setLastDonationDate(donor.getLastDonationDate());
            donorPojo.setDonorRecords(donorRecords);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, donorPojo, GlobalConstant.Message.SUCCESS_MESSAGE);
    }



    @PostMapping (value = "/donor")
    public Donor createDonor(@RequestBody Donor donor){
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
