package org.yeasheng.entity;

import java.util.Objects;

public class Product {

    private String name;
    private long productNo;

    public Product(String name, long productNo) {
        this.name = name;
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductNo() {
        return productNo;
    }

    public void setProductNo(long productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productNo=" + productNo +
                '}';
    }

}