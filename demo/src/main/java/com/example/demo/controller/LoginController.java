package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody User user) throws JsonProcessingException {
        User thisUse=userService.login(user);
        Map<String,Object> map=new HashMap<>();
        if(thisUse!=null) {
            //登录成功，生成并返回Token
            String token= TokenUtil.sign(thisUse);
            HashMap<String,Object> hs=new HashMap<>();
            map.put("token",token);

            if(thisUse.getIsadmin())
                map.put("result","admin");
            else
                map.put("result","normal");
        }
        else {
            map.put("result","failure");
        }
        return map;
    }

    @RequestMapping("/validatePhone")
    @ResponseBody
    public Map<String,Object> validatePhone(String phone){
        boolean flag = userService.validatePhone(phone);

        Map<String,Object> map=new HashMap<>();
        if(flag)
            map.put("result","OK");
        else
            map.put("result","NO");
        return map;
    }

    @RequestMapping("/signin")
    @ResponseBody
    public Map<String,Object> signin(@RequestBody User user){
        user.setIsadmin(false);
        boolean flag = userService.signin(user);

        Map<String,Object> map=new HashMap<>();
        if(flag)
            map.put("result","success");
        else
            map.put("result","failure");
        return map;
    }
}
