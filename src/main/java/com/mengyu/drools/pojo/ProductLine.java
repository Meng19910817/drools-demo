package com.mengyu.drools.pojo;

/**
 * @author zoumengyu
 */
public class ProductLine {

    private Product product;
    private double number;

    public ProductLine() {
    }

    public ProductLine(Product product, double number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "product=" + product +
                ", number=" + number +
                '}';
    }
}
