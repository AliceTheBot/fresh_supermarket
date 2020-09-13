package com.example.demo.service.impl;

import com.example.demo.dao.GoodsDao;
import com.example.demo.dao.GoodsOrderDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsOrder;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GoodsOrderServiceImpl implements GoodsOrderService {
    @Autowired
    GoodsOrderDao goodsOrderDao;
    @Autowired
    UserDao userDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderDao orderDao;

    @Override
    public boolean addToShoppingCart(Integer goodsId, String phone) {
        User user=userDao.findByPhone(phone);
        if(user!=null){
            Goods goods=goodsDao.findById(goodsId).get();

            GoodsOrder goodsOrder=new GoodsOrder();
            goodsOrder.setGoods_id(goods);
            goodsOrder.setUser_id(user);
            goodsOrder.setNumbers(1);
            goodsOrder.setIschecked(false);

            goodsOrderDao.save(goodsOrder);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<GoodsOrder> getMyShoppingCart(String phone) {
        User user=userDao.findByPhone(phone);
        if(user!=null){
            return  goodsOrderDao.findAllByUser_idAAndIscheckedIsFalse(user.getId());
        }
        return null;
    }

    @Override
    public boolean addGoodsOrderNumber(Integer goid, Integer num) {
        GoodsOrder go=goodsOrderDao.findById(goid).get();
        go.setNumbers(num);
        return goodsOrderDao.save(go)!=null;
    }

    @Override
    public boolean removeFromCart(Integer goid) {
        goodsOrderDao.deleteById(goid);
        return !goodsOrderDao.existsById(goid);
    }

    @Override
    public boolean checkout(String phone,Order order) {
        User user=userDao.findByPhone(phone);

        List<GoodsOrder> goodsOrders=goodsOrderDao.findAllByUser_idAAndIscheckedIsFalse(user.getId());
        if(goodsOrders.size()>0) {
            double price = 0;
            for (GoodsOrder go : goodsOrders) {
                price += go.getGoods_id().getPrice() * go.getNumbers();
            }

            //创建一个状态为未付款的 order
            order.setUser_id(user);
            order.setOdate(new Date());
            order.setOstatus("待付款");
            order.setPrice(price);

            order = orderDao.save(order);

            //将该用户下的所有goodsOrder置为true
            //将该order的id赋值给goodsOrder
            Integer flag1 = goodsOrderDao.updateOrderId(user.getId(),order.getId());
            Integer flag2 = goodsOrderDao.check(user.getId());
            return flag1 > 0 && flag2 > 0;
        }
        return false;
    }
}
