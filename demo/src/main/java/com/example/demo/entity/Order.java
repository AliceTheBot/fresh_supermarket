package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date odate;
    @Column
    private Double price;
    @Column
    private String ostatus;
    @ManyToOne
    @JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT ))
    private User user_id;
    @Column
    private String phone;
    @Column
    private String receiver;
    @Column
    private String address;
    @OneToMany(mappedBy = "order_id",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<GoodsOrder> goodsOrders;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<GoodsOrder> getGoodsOrders() {
        return goodsOrders;
    }

    public void setGoodsOrders(List<GoodsOrder> goodsOrders) {
        this.goodsOrders = goodsOrders;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
