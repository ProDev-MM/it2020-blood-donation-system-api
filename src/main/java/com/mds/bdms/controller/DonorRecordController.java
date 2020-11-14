package com.mds.bdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.bdms.constant.GlobalConstant;
import com.mds.bdms.entity.DonorRecord;
import com.mds.bdms.pojo.DonorRecordPojo;
import com.mds.bdms.response.BaseResponse;
import com.mds.bdms.service.DonorRecordService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DonorRecordController {
    @Autowired
    DonorRecordService donorRecordService;

    @GetMapping(value = "/donorRecords")
    public BaseResponse getDonorRecord(){
        List<DonorRecord> donorRecord;
        try{
            donorRecord= donorRecordService.getDonorRecord();
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, donorRecord, GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @GetMapping(value="/donorRecord/{id}")
    public BaseResponse getById(@PathVariable Long id){
        DonorRecord donorRecord;
        try{
            donorRecord =donorRecordService.findById(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, donorRecord, GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/donorRecord")
    public BaseResponse createDonorRecord(@RequestBody DonorRecord donorRecord){
        try {
            donorRecord = donorRecordService.addDonorRecord(donorRecord);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, donorRecord, GlobalConstant.Message.SUCCESS_MESSAGE);

    }

    @DeleteMapping(value="/donorRecord/{id}")
    public BaseResponse deleteDonorRecord(@PathVariable Long id){
        try {
            donorRecordService.deleteDonorRecord(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, null, GlobalConstant.Message.SUCCESS_MESSAGE);

    }

    @PutMapping (value = "/donorRecord")
    public BaseResponse updateDonorRecord(@RequestBody DonorRecordPojo donorRecordPojo) {
       DonorRecord donorRecords;

        try{
            DonorRecord donorRecord = donorRecordService.findById(donorRecordPojo.getId());

            if(donorRecord==null) {
                return null;
            }
            donorRecord.setId(donorRecordPojo.getDonorId());
            donorRecord.setDonationDate(donorRecordPojo.getDonationDate());
            donorRecord.setDonorId(donorRecordPojo.getDonorId());
            donorRecords=donorRecordService.save(donorRecord);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
        }

        return new BaseResponse(GlobalConstant.SUCCESS, donorRecords,GlobalConstant.Message.SUCCESS_MESSAGE);

    }
}
