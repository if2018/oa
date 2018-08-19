package com.example.oa.service.impl;

import com.example.oa.bean.HouseSource;
import com.example.oa.dao.HouseSourceDao;
import com.example.oa.exception.BusinessException;
import com.example.oa.service.HouseSourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class HouseSourceImpl implements HouseSourceService {

    @Autowired
    private HouseSourceDao houseSourceDao;

    @Override
    public Page<HouseSource> findAll(Pageable pageable) {
        return houseSourceDao.findAll(pageable);
    }

    @Override
    public List<HouseSource> findAll() {
        return houseSourceDao.findAll();
    }

    @Override
    public HouseSource findOne(Integer houseId) {
        return houseSourceDao.findById(houseId).get();
    }

    @Override
    public List<HouseSource> findByHouseIdIn(List<Integer> houseIdList) {
        return houseSourceDao.findByHouseIdIn(houseIdList);
    }

    @Override
    public HouseSource save(HouseSource houseSource) {
        return houseSourceDao.save(houseSource);
    }

    //分页模糊查询
    //navigatePages显示的导航条数
    //
//    public Page<HouseSource> blurryHouseSource(String name,Integer pageNum,Integer pageSize,Integer navigatePages) {
//
//        if(name == null || name.equals("")){
//            throw new BusinessException("查询条件不能为空");
//        }else {
//            Sort sort = new Sort(Sort.Direction.DESC, "id");
//            Pageable pageable = new PageRequest(pageNum, pageSize, sort);
//            Page<HouseSource> pages=houseSourceDao.likeHouseSource(name,pageable);
//            //Iterator<HouseSource> it=pages.iterator();
//
//            return pages;
//        }
//
//
//    }
}
