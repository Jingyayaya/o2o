package com.science.o2o.dao;

import com.science.o2o.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * display area list
     * @return areaList
     */
    List<Area> queryArea();
}
