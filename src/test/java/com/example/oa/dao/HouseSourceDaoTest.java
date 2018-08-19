package com.example.oa.dao;

import com.example.oa.bean.HouseSource;
import com.example.oa.bean.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseSourceDaoTest {

    @Autowired
    private HouseSourceDao houseSourceDao;

    @Test
    public void test1(){
        System.out.println(houseSourceDao.findAll());
    }

    @Test
    public void test2(){
        Sort sort =new Sort(Sort.Direction.DESC, "houseId");
        Pageable pageable = new PageRequest(1, 2, sort);

        List<HouseSource> houseSourceList=houseSourceDao.likeHouseSource("保利");


        //设置作用域
        //houseSourceList.setAttribute("paging", page);



        System.out.println();
        for (HouseSource  h:houseSourceList
             ) {
            System.out.println(h.getHouseId()+" "+h.getHouseEstate());
        }

    }


}