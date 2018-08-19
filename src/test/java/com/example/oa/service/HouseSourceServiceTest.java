package com.example.oa.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseSourceServiceTest {


    @Autowired
    private HouseSourceService houseSourceService;

    @Test
    public void findAll() {
    }

    @Test
    public void findAll1() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findByHouseIdIn() {
        System.out.println(houseSourceService.findByHouseIdIn(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void save() {
    }

}