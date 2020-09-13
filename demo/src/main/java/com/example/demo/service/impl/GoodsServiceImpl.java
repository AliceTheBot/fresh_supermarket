package com.example.demo.service.impl;

import com.example.demo.dao.GoodsDao;
import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public ArrayList<Goods> findAll() {
        return (ArrayList<Goods>) goodsDao.findAllByIssale(true);
    }

    @Override
    public Goods findById(Integer id) {
        return goodsDao.findById(id).get();
    }

    @Override
    public void update(Goods goods) {
        goodsDao.save(goods);
    }

    @Override
    public void insert(Goods goods) {
        goodsDao.save(goods);
    }

    @Override
    public void offShelves(Integer id) {
        Goods goods=goodsDao.findById(id).get();
        goods.setIssale(false);
        goodsDao.save(goods);
    }

    @Override
    public ArrayList<Goods> findAllUnsale() {
        return (ArrayList<Goods>) goodsDao.findAllByIssale(false);
    }

    @Override
    public void onShelves(Integer id) {
        Goods goods=goodsDao.findById(id).get();
        goods.setIssale(true);
        goodsDao.save(goods);
    }

    @Override
    public ArrayList<Goods> findGoodsByName(String keyword) {
        return goodsDao.findAllByGnameLikeAndIssale(keyword,true);
    }

    @Override
    public ArrayList<Goods> findGoodsByNameAndSort(String keyword, Integer sortid) {
        return goodsDao.findByGnameLikeAndSort_Id(keyword,sortid);
    }
}