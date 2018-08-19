package com.example.oa.dao;

import com.example.oa.bean.HouseSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HouseSourceDao extends JpaRepository<HouseSource,Integer> {
    List<HouseSource> findByHouseIdIn(List<Integer> houseIdList);

    //转为公盘操作
    @Transactional
    @Modifying
    @Query("update HouseSource a set a.broker=?1 where a.houseId=?2")
    int TurnToAPublicDish(String broker,Integer houseId);
    //模糊查询
    @Transactional
    @Modifying
    @Query("select a from HouseSource a where concat(a.houseEstate,a.houseSize,a.houseNumber,a.totalPrice) like %?1%")
    List<HouseSource> likeHouseSource(String name);


}
