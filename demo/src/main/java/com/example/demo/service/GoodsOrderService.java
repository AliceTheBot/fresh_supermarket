package com.example.demo.service;

import com.example.demo.entity.GoodsOrder;
import com.example.demo.entity.Order;

import java.util.List;

public interface GoodsOrderService {
    boolean addToShoppingCart(Integer goodsId, String phone);

    List<GoodsOrder> getMyShoppingCart(String phone);

    boolean addGoodsOrderNumber(Integer goid, Integer num);

    boolean removeFromCart(Integer goid);

    boolean checkout(String phone, Order order);
}
