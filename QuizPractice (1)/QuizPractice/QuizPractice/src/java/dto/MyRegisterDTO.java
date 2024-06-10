/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class MyRegisterDTO {
    private int id;
    private String subjectName;
    private Date registerTime;
    private String packageName;
    private double totalCost;
    private String status;

    public MyRegisterDTO(int id, String subjectName, Date registerTime, String packageName, double totalCost, String status) {
        this.id = id;
        this.subjectName = subjectName;
        this.registerTime = registerTime;
        this.packageName = packageName;
        this.totalCost = totalCost;
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyRegisterDTO{" + "id=" + id + ", subjectName=" + subjectName + ", registerTime=" + registerTime + ", packageName=" + packageName + ", totalCost=" + totalCost + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
