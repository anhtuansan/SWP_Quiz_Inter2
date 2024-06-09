/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class PricePackage2 {
    private int id;
    private String name;
    private int duration;
    private double salePrice;
    private double price;
    private double originalPrice;

    public PricePackage2(int id, String name, int duration, double salePrice, double price, double originalPrice) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.salePrice = salePrice;
        this.price = price;
        this.originalPrice = originalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public String toString() {
        return "PricePackage2{" + "id=" + id + ", name=" + name + ", duration=" + duration + ", salePrice=" + salePrice + ", price=" + price + ", originalPrice=" + originalPrice + '}';
    }
    
    
}
