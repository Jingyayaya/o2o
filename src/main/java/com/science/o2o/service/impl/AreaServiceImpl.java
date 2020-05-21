package com.science.o2o.service.impl;

import com.science.o2o.dao.AreaDao;
import com.science.o2o.entity.Area;
import com.science.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        List<String> cmb=new ArrayList<>();
        List<String> list=new ArrayList<>(cmb);
        boolean flag=true;
        flag=false;
        Set<Integer> s=new HashSet<>();


        return areaDao.queryArea();
    }
}


