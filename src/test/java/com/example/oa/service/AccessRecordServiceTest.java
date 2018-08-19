package com.example.oa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccessRecordServiceTest {



    @Autowired
    private AccessRecordService accessRecordService;

    @Test
    public void findAll() {

        System.out.println(accessRecordService.findAll());
    }

    @Test
    public void findByHouseId() {
        System.out.println(accessRecordService.findByHouseId(1));
    }
}