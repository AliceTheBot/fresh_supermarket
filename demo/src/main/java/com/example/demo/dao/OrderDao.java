package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
    @Query(nativeQuery = true,value = "select * from orders where user_id = ?1 order by odate desc")
    List<Order> findAllByUser_id(Integer userId);

    @Modifying
    @Query(nativeQuery = true,value = "update orders set ostatus='待发货' where id=?1")
    Integer payOrderById(Integer oid);

    @Modifying
    @Query(nativeQuery = true,value = "update orders set ostatus='待收货' where id=?1")
    Integer deliveryOrderById(Integer oid);

    List<Order> findAllByOstatus(String ostatus);
}
