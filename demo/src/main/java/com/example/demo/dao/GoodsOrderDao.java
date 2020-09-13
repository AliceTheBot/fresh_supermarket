package com.example.demo.dao;

import com.example.demo.entity.GoodsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsOrderDao extends JpaRepository<GoodsOrder,Integer> {
    @Query(nativeQuery = true,value = "select * from goods_orders where user_id = ?1 and ischecked=false")
    public List<GoodsOrder> findAllByUser_idAAndIscheckedIsFalse(Integer user_id);

    @Modifying
    @Query(nativeQuery = true,value = "update goods_orders set order_id=?2 where user_id=?1 and ischecked=false")
    public Integer updateOrderId(Integer userId, Integer orderId);

    @Modifying
    @Query(nativeQuery = true,value = "update goods_orders set ischecked=true where user_id=?1 and ischecked=false")
    public Integer check(Integer userId);

}
