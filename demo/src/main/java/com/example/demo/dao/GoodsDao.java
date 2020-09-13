package com.example.demo.dao;

import com.example.demo.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GoodsDao extends JpaRepository<Goods,Integer> {

    public ArrayList<Goods> findAllByIssale(Boolean flag);

    ArrayList<Goods> findAllByGnameLikeAndIssale(String keyword, boolean b);

    @Query(nativeQuery = true,value = "select * from goods where gname like %?1% and sort_id=?2 and issale=true")
    ArrayList<Goods> findByGnameLikeAndSort_Id(String keyword, Integer sortid);
}
