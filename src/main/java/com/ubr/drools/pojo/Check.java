package com.ubr.drools.pojo;

import java.util.List;

/**
 * @author zoumengyu
 */
public class Check {

    private List<ProductLine> productLines;
    private double totalAmount;
    private double discountAmount;

    public Check() {
    }

    public List<ProductLine> getProductLines() {
        return productLines;
    }

    public void setProductLines(List<ProductLine> productLines) {
        this.productLines = productLines;
    }

    public double getTotalAmount() {
        double amount = 0;
        for(ProductLine productLine : productLines){
            amount += productLine.getNumber() * productLine.getProduct().getAmount();
        }
        return amount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Check{" +
                "productLines=" + productLines +
                ", totalAmount=" + totalAmount +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
