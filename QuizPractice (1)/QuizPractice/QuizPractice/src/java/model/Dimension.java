/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Dimension {
    private int DimensionId;
    private String DimensionName;
    private String Type;
    private String Description;

    public Dimension(int DimensionId, String DimensionName, String Type, String Description) {
        this.DimensionId = DimensionId;
        this.DimensionName = DimensionName;
        this.Type = Type;
        this.Description = Description;
    }

    public int getDimensionId() {
        return DimensionId;
    }

    public void setDimensionId(int DimensionId) {
        this.DimensionId = DimensionId;
    }

    public String getDimensionName() {
        return DimensionName;
    }

    public void setDimensionName(String DimensionName) {
        this.DimensionName = DimensionName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Dimension{" + "DimensionId=" + DimensionId + ", DimensionName=" + DimensionName + ", Type=" + Type + ", Description=" + Description + '}';
    }
    
    
}
