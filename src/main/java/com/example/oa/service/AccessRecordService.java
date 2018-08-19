package com.example.oa.service;

import com.example.oa.bean.AccessRecord;
import org.springframework.stereotype.Service;

import java.util.List;



public interface AccessRecordService {

    //查询所有
    List<AccessRecord> findAll();

    //根据房产id查询
    List<AccessRecord> findByHouseId(Integer houseId);

    AccessRecord save(AccessRecord accessRecord);
}
