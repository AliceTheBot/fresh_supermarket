package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getMyOrders(String phone);

    boolean pay(Integer oid);

    List<Order> getAllOrders();

    boolean delivery(Integer oid);

    List<Order> getNeedPayOrders();

    List<Order> getNeedDeliveryOrders();

    List<Order> getNeedReceiptOrders();
}
