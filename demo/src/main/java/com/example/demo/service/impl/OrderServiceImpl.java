package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserDao userDao;

    @Override
    public List<Order> getMyOrders(String phone) {
        User user=userDao.findByPhone(phone);
        return orderDao.findAllByUser_id(user.getId());
    }

    @Override
    public boolean pay(Integer oid) {
        return orderDao.payOrderById(oid)>0;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public boolean delivery(Integer oid) {
        return orderDao.deliveryOrderById(oid)>0;
    }

    @Override
    public List<Order> getNeedPayOrders() {
        return orderDao.findAllByOstatus("待付款");
    }

    @Override
    public List<Order> getNeedDeliveryOrders() {
        return orderDao.findAllByOstatus("待发货");
    }

    @Override
    public List<Order> getNeedReceiptOrders() {
        return orderDao.findAllByOstatus("待收货");
    }
}
