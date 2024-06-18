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
public class Lesson2 {
    int id;
    String name;
    int creatorId;
    Date updateAt;
    Date createdAt;
    int status;
    String content;
    String media;
    int lessonIndex;
    String type;

    public Lesson2(int id, String name, int creatorId, Date updateAt, Date createdAt, int status, String content, String media, int lessonIndex, String type) {
        this.id = id;
        this.name = name;
        this.creatorId = creatorId;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
        this.status = status;
        this.content = content;
        this.media = media;
        this.lessonIndex = lessonIndex;
        this.type = type;
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

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getLessonIndex() {
        return lessonIndex;
    }

    public void setLessonIndex(int lessonIndex) {
        this.lessonIndex = lessonIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lesson2{" + "id=" + id + ", name=" + name + ", creatorId=" + creatorId + ", updateAt=" + updateAt + ", createdAt=" + createdAt + ", status=" + status + ", content=" + content + ", media=" + media + ", lessonIndex=" + lessonIndex + ", type=" + type + '}'+'\n';
    }
    
    

   
}
