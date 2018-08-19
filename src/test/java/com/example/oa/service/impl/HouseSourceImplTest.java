package com.example.oa.service.impl;

import com.example.oa.bean.HouseSource;
import com.example.oa.service.HouseSourceService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseSourceImplTest {

    @Autowired
    private HouseSourceService houseSourceService;

    @Test
    public void findAll() {
        Page<HouseSource> page=houseSourceService.findAll(new PageRequest(0,10));
        for (HouseSource p:page
             ) {
            System.out.println(p.getHouseEstate());
        }
    }

    @Test
    public void findOne() {
        HouseSource houseSource=houseSourceService.findOne(1);
        System.out.println(houseSource.toString());
    }

    @Test
    public void save() {
    }

//    @Test
//    public void blurryHouseSource(){
//        PageInfo<HouseSource> houseSourceList=houseSourceService.blurryHouseSource("保利",5);
//        System.out.println(houseSourceList.toString());
//    }

}