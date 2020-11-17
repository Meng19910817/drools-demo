package com.ubr.drools.pojo.example;

/**
 * @author zoumengyu
 */
public class Apple {

    private String colour;
    private double weight;


    public Apple() {
    }

    public Apple(String colour, double weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColor(String colour) {
        this.colour = colour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
