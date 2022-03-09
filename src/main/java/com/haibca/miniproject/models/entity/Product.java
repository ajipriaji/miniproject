package com.haibca.miniproject.models.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column 
    private String description;

    @Column
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product () {

    }

    public Product (Long id) {
        this.id = id;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(BigDecimal price) {
        this.price = price;
    }

    public Product( String description, Integer stock, Category category) {
        this.description = description;
    }

    public Product(Integer stock) {
        this.stock = stock;
    }

    public Product(Category category) {
        this.category = category;
    }

    public Product(Long id, String name, BigDecimal price, String description, Integer stock, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}
