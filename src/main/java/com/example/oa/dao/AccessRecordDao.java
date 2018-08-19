package com.example.oa.dao;

import com.example.oa.bean.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessRecordDao extends JpaRepository<AccessRecord,Integer>{
    List<AccessRecord> findByHouseId(Integer houseId);
}
