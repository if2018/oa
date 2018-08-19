package com.example.oa.dao;

import com.example.oa.bean.AccessRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class AccessRecordDaoTest {

    @Autowired
    private AccessRecordDao accessRecordDao;

    @Test
    public void test1(){
        System.out.println(accessRecordDao.findAll().toString());
    }

    @Test
    public void findByHouseId() {
        System.out.println(accessRecordDao.findByHouseId(2));
    }
    @Test
    public void save(){
        AccessRecord accessRecord=new AccessRecord();

        accessRecord.setId(3);
        accessRecord.setHouseId(2);
        accessRecord.setRecord("没有接电话");
        accessRecordDao.save(accessRecord);

    }
}