package com.science.o2o.dao;

import com.science.o2o.entity.Shop;

public interface ShopDao {
    /**
     * Add new shop
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * Update shop
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
