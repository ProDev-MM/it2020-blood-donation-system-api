package com.mds.bdms.controller;

import java.util.List;

import com.mds.bdms.pojo.DonorRecordPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mds.bdms.constant.GlobalConstant;
import com.mds.bdms.entity.DonorRecord;
import com.mds.bdms.response.BaseResponse;
import com.mds.bdms.service.DonorRecordService;


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
    public BaseResponse createDonorRecord(@RequestBody DonorRecordPojo donorRecordPojo){
        DonorRecord donorRecord = null;
        try {
            donorRecord = donorRecordService.addDonorRecord(donorRecordPojo);
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

    // @PutMapping (value = "/donorRecord")
    // public BaseResponse updateDonorRecord(@RequestBody DonorRecordPojo donorRecordPojo) {
    //    DonorRecord donorRecords;

    //     try{
    //         DonorRecord donorRecord = donorRecordService.findById(donorRecordPojo.getId());

    //         if(donorRecord==null) {
    //             return null;
    //         }
    //         donorRecord.setId(donorRecordPojo.getDonorId());
    //         donorRecord.setDonationDate(donorRecordPojo.getDonationDate());
    //         donorRecord.setDonorId(donorRecordPojo.getDonorId());
    //         donorRecords=donorRecordService.save(donorRecord);
    //     }catch(Exception e) {
    //         System.out.println("Error occur "+e.getMessage());
    //         return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
    //     }

    //     return new BaseResponse(GlobalConstant.SUCCESS, donorRecords,GlobalConstant.Message.SUCCESS_MESSAGE);

    // }
}
