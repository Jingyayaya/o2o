package com.science.o2o.service;

import com.science.o2o.dto.ShopExecution;
import com.science.o2o.entity.Shop;
import com.science.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {

    /**
     * Add shop including images processing
     *
     * @param shop
     * @param
     * @param
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
