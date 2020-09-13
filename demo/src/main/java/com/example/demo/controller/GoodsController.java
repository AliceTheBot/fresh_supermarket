package com.example.demo.controller;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Sort;
import com.example.demo.service.GoodsService;
import com.example.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    SortService sortService;

    @RequestMapping("/findAllGoods")
    @ResponseBody
    public ArrayList<Goods> findAll(){
        return goodsService.findAll();
    }

    @RequestMapping("/findAllUnSaleGoods")
    @ResponseBody
    public ArrayList<Goods> findAllUnsale(){
        return goodsService.findAllUnsale();
    }

    @RequestMapping("/findAllSorts")
    @ResponseBody
    public ArrayList<Sort> findAllSorts(){
        return sortService.findAll();
    }

    @RequestMapping("/findGoodsById")
    @ResponseBody
    public Goods findById(Integer id){
        return goodsService.findById(id);
    }

    @RequestMapping("/findGoodsByName")
    @ResponseBody
    public ArrayList<Goods> findGoodsByName(String keyword){
        return goodsService.findGoodsByName("%"+keyword+"%");
    }

    @RequestMapping("/findGoodsByNameAndSort")
    @ResponseBody
    public ArrayList<Goods> findGoodsByNameAndSort(String keyword,Integer sortid){
        return goodsService.findGoodsByNameAndSort("%"+keyword+"%",sortid);
    }

//后端区
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\Auber\\WebstormProjects\\fresh_supermarket\\src\\assets\\" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateGoods")
    @ResponseBody
    public void updateGoods(@RequestBody Goods goods){
        goodsService.update(goods);
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public void insertGoods(@RequestBody Goods goods){
        goods.setIssale(true);
        goodsService.insert(goods);
    }

    @RequestMapping("/offShelves")
    @ResponseBody
    public void offShelves(Integer id){
        goodsService.offShelves(id);
    }

    @RequestMapping("/onShelves")
    @ResponseBody
    public void onShelves(Integer id){
        goodsService.onShelves(id);
    }
}
