package com.sciecnce.o2o.service;

import com.sciecnce.o2o.BaseTest;
import com.science.o2o.dao.AreaDao;
import com.science.o2o.entity.Area;
import com.science.o2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList=areaService.getAreaList();
        assertEquals("east", areaList.get(0).getAreaName());
    }


}
