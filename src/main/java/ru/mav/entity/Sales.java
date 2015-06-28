package ru.mav.entity;
// Generated 27.06.2015 20:23:22 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sales generated by hbm2java
 */
@Entity
@Table(name="sales"
    ,catalog="public"
)
public class Sales  implements java.io.Serializable {


     private int goodsId;
     private Integer number;
     private Integer cost;
     private String date;

    public Sales() {
    }

	
    public Sales(int goodsId) {
        this.goodsId = goodsId;
    }
    public Sales(int goodsId, Integer number, Integer cost, String date) {
       this.goodsId = goodsId;
       this.number = number;
       this.cost = cost;
       this.date = date;
    }
   
     @Id 

    
    @Column(name="goods_id", unique=true, nullable=false)
    public int getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    
    @Column(name="number")
    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    
    @Column(name="cost")
    public Integer getCost() {
        return this.cost;
    }
    
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    
    @Column(name="date", length=10)
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }




}


