/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class SubjectPackagePriceDTO {
    private int id;
    private String packageName;
    private int duration;
    private double salePrice;
    private double price;   
    private String status;

    public SubjectPackagePriceDTO(int id, String packageName, int duration, double price, double salePrice, String status) {
        this.id = id;
        this.packageName = packageName;
        this.duration = duration;
        this.price = price;
        this.salePrice = salePrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubjectPackagePriceDTO{" + "id=" + id + ", packageName=" + packageName + ", duration=" + duration + ", price=" + price + ", salePrice=" + salePrice + ", status=" + status + '}';
    } 
}
