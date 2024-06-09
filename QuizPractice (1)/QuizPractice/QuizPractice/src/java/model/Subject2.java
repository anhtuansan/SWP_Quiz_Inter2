/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Subject2 {
    private int id;
    private String name;
    private int creatorId;
    private Date creatorAt;
    private Date updateAt;
    private int status;
    private String img;
    private String description;

    public Subject2(int id, String name, int creatorId, Date creatorAt, Date updateAt, int status, String img, String description) {
        this.id = id;
        this.name = name;
        this.creatorId = creatorId;
        this.creatorAt = creatorAt;
        this.updateAt = updateAt;
        this.status = status;
        this.img = img;
        this.description = description;
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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatorAt() {
        return creatorAt;
    }

    public void setCreatorAt(Date creatorAt) {
        this.creatorAt = creatorAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
