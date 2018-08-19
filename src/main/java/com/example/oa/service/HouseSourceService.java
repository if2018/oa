package com.example.oa.service;

import com.example.oa.bean.HouseSource;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface HouseSourceService {
    //分页查询所有
    Page<HouseSource> findAll(Pageable pageable);
    //不分页查询所有
    List<HouseSource> findAll();
    //根据id查询
    HouseSource findOne(Integer houseId);
    //根据idList查询
    List<HouseSource> findByHouseIdIn(List<Integer> houseIdList);


    //添加数据
    HouseSource save(HouseSource houseSource);

    //模糊查询
    //Page<HouseSource> blurryHouseSource(String name,Integer pageNum,Integer pageSize,Integer navigatePages);

}
