package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/getMyOrders")
    @ResponseBody
    public List<Order> getMyOrders(HttpServletRequest request) {
        String phone = TokenUtil.getPhone(request.getHeader("Authorization"));
        return orderService.getMyOrders(phone);
    }

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String,Object> pay(Integer oid){
        Map<String,Object> map=new HashMap<>();
        boolean result=orderService.pay(oid);
        if(result){
            map.put("result","OK");
        }else {
            map.put("result", "NO");
        }
        return map;
    }

    @RequestMapping("/getAllOrders")
    @ResponseBody
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }



    @RequestMapping("/delivery")
    @ResponseBody
    public Map<String,Object> delivery(Integer oid){
        Map<String,Object> map=new HashMap<>();
        boolean result=orderService.delivery(oid);
        if(result){
            map.put("result","OK");
        }else {
            map.put("result", "NO");
        }
        return map;
    }

    @RequestMapping("/getNeedPayOrders")
    @ResponseBody
    public List<Order> getNeedPayOrders(){
        return orderService.getNeedPayOrders();
    }

    @RequestMapping("/getNeedDeliveryOrders")
    @ResponseBody
    public List<Order> getNeedDeliveryOrders(){
        return orderService.getNeedDeliveryOrders();
    }

    @RequestMapping("/getNeedReceiptOrders")
    @ResponseBody
    public List<Order> getNeedReceiptOrders(){
        return orderService.getNeedReceiptOrders();
    }

}
