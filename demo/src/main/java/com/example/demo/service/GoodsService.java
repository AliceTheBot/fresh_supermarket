package com.example.demo.service;

import com.example.demo.entity.Goods;

import java.util.ArrayList;

public interface GoodsService {
    ArrayList<Goods> findAll();

    Goods findById(Integer id);

    void update(Goods goods);

    void insert(Goods goods);

    void offShelves(Integer id);

    ArrayList<Goods> findAllUnsale();

    void onShelves(Integer id);

    ArrayList<Goods> findGoodsByName(String keyword);

    ArrayList<Goods> findGoodsByNameAndSort(String s, Integer sortid);
}
