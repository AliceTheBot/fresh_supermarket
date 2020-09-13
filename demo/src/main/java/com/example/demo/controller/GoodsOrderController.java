package com.example.demo.controller;

import com.example.demo.entity.GoodsOrder;
import com.example.demo.entity.Order;
import com.example.demo.service.GoodsOrderService;
import com.example.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsOrderController {
    @Autowired
    GoodsOrderService goodsOrderService;

    @RequestMapping("/addToShoppingCart")
    @ResponseBody
    public Map<String,Object> addToShoppingCart(Integer goodsId, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        String phone= TokenUtil.getPhone(request.getHeader("Authorization"));
        boolean result=goodsOrderService.addToShoppingCart(goodsId,phone);
        if(result){
            map.put("result","OK");
        }else{
            map.put("result","NO");
        }
        return map;
    }

    @RequestMapping("/getMyShoppingCart")
    @ResponseBody
    public List<GoodsOrder> getMyShoppingCart(HttpServletRequest request){
        //获取到用户ID 查询所有该用户未Check的GoodsOrder 返回
        String phone= TokenUtil.getPhone(request.getHeader("Authorization"));
        return goodsOrderService.getMyShoppingCart(phone);
    }

    @RequestMapping("/addGoodsOrderNumber")
    @ResponseBody
    public Map<String,Object> addGoodsOrderNumber(Integer goid,Integer num){
        Map<String,Object> map=new HashMap<>();
        boolean result=goodsOrderService.addGoodsOrderNumber(goid,num);
        if(result)
            map.put("result","OK");
        else
            map.put("result","NO");
        return map;
    }

    @RequestMapping("/removeFromCart")
    @ResponseBody
    public Map<String,Object> removeFromCart(Integer goid){
        Map<String,Object> map=new HashMap<>();
        boolean result=goodsOrderService.removeFromCart(goid);
        if(result)
            map.put("result","OK");
        else
            map.put("result","NO");
        return map;
    }

    @RequestMapping("/checkout")
    @ResponseBody
    public Map<String,Object> checkout(HttpServletRequest request, @RequestBody Order order){
        String phone= TokenUtil.getPhone(request.getHeader("Authorization"));
        boolean result=goodsOrderService.checkout(phone,order);

        Map<String,Object> map=new HashMap<>();
        if(result)
            map.put("result","OK");
        else
            map.put("result","NO");
        return map;
    }
}
