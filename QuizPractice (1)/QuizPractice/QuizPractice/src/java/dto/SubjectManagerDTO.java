/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class SubjectManagerDTO {
    private int id;
    private String name;
    private String dimensionName;
    private int numberOfLesson;
    private int status;

    public SubjectManagerDTO(int id, String name, String dimensionName, int numberOfLesson, int status) {
        this.id = id;
        this.name = name;
        this.dimensionName = dimensionName;
        this.numberOfLesson = numberOfLesson;
        this.status = status;
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

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubjectManagerDTO{" + "id=" + id + ", name=" + name + ", dimensionName=" + dimensionName + ", numberOfLesson=" + numberOfLesson + ", status=" + status + '}';
    }
    
    
    
}
