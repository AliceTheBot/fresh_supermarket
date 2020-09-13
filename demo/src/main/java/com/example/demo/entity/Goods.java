package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String gname;
    @Column
    private Double price;
    @Column
    private Integer store;
    @Column
    private String origin;
    @Column
    private Double weight;
    @Column
    private String storage_condition;
    @Column
    private  String photo;
    @Column
    private Boolean issale;
    @ManyToOne
    @JoinColumn(name="sort_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT ))
    private Sort sort_id;

    public Boolean getIssale() {
        return issale;
    }

    public void setIssale(Boolean issale) {
        this.issale = issale;
    }

    public Sort getSort_id() {
        return sort_id;
    }

    public void setSort_id(Sort sort) {
        this.sort_id = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStorage_condition() {
        return storage_condition;
    }

    public void setStorage_condition(String storage_condition) {
        this.storage_condition = storage_condition;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}
