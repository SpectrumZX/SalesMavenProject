package ru.mav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="goods"
    ,catalog="public"
)
public class Goods  implements java.io.Serializable {

     private Integer id;
     private String name;
     private int price;
     private Integer count_sales;  // количесвто продаж товара
 
    public Goods() {
    }
    
    public Goods(String name, int price) {
       this.name = name;
       this.price = price;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)  
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="price", nullable=false)
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    @Transient
    public Integer getCountSales() {
    return count_sales;
    }

    public void setCountSales(Integer count_sales) {
       this.count_sales = count_sales;
    }


}


