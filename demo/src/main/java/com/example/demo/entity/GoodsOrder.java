package com.example.demo.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="goods_orders")
public class GoodsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="goods_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT ))
    private Goods goods_id;
//    @ManyToOne
//    @JoinColumn(name="order_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT ))
    @Column
    private Integer order_id;
    @ManyToOne
    @JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT ))
    private User user_id;
    @Column
    private Integer numbers;
    @Column
    private Boolean ischecked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Goods goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Boolean getIschecked() {
        return ischecked;
    }

    public void setIschecked(Boolean ischecked) {
        this.ischecked = ischecked;
    }
}
