package com.sciecnce.o2o.dao;

import com.sciecnce.o2o.BaseTest;
import com.science.o2o.dao.ShopDao;
import com.science.o2o.entity.Area;
import com.science.o2o.entity.PersonInfo;
import com.science.o2o.entity.Shop;
import com.science.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    @Ignore
    public void testInsertShop(){
        Shop shop =new Shop();
        PersonInfo owner=new PersonInfo();
        Area area= new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test shop");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("under review");

        int effectnum=shopDao.insertShop(shop);
        assertEquals(1,effectnum);
    }

    @Test
    public void testUpdateShop(){
        Shop shop =new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("test change desc");
        shop.setShopAddr("test change address");
        shop.setLastEditTime(new Date());
        int effectnum=shopDao.updateShop(shop);
        assertEquals(1,effectnum);
    }
}
