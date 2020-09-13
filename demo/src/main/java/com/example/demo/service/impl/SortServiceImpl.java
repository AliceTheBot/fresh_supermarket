package com.example.demo.service.impl;

import com.example.demo.dao.SortDao;
import com.example.demo.entity.Sort;
import com.example.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Service
@Transactional
public class SortServiceImpl implements SortService {
    @Autowired
    SortDao sortDao;

    @Override
    public ArrayList<Sort> findAll() {
        return (ArrayList<Sort>) sortDao.findAll();
    }
}
