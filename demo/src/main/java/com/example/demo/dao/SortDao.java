package com.example.demo.dao;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortDao extends JpaRepository<Sort,Integer> {
}
