package ru.mav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sales", catalog = "public"
)
public class Sales implements java.io.Serializable {

    private Integer id;
    private int goodsId;
    private Integer number;
    private Integer cost;
    private String date;
    private String nameOfGoods;

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
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "goods_id", unique = true, nullable = false)
    public int getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "number")
    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "cost")
    public Integer getCost() {
        return this.cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column(name = "date", length = 10)
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Transient
    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }

}
