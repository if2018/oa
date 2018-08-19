package com.example.oa.service.impl;

import com.example.oa.bean.AccessRecord;
import com.example.oa.dao.AccessRecordDao;
import com.example.oa.service.AccessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessRecordImpl implements AccessRecordService{


    @Autowired
    private AccessRecordDao accessRecordDao;

    @Override
    public List<AccessRecord> findAll() {
        return accessRecordDao.findAll();
    }

    @Override
    public List<AccessRecord> findByHouseId(Integer houseId) {
        return accessRecordDao.findByHouseId(houseId);
    }

    @Override
    public AccessRecord save(AccessRecord accessRecord) {
        return accessRecordDao.save(accessRecord);
    }
}
