/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class BlogManagerDetailDTO {
    private int id;
    private String title;
    private String categoryName;
    private String content;
    private boolean status;
    private String thumbnail;
    private String briefinfo;

    public BlogManagerDetailDTO() {
    }

    public BlogManagerDetailDTO(int id, String title, String categoryName, String content, boolean status, String briefinfo) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.content = content;
        this.status = status;
        this.briefinfo = briefinfo;
    }
    

    public BlogManagerDetailDTO(int id, String title, String categoryName, String content, boolean status,String thumbnail, String briefinfo) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.content = content;
        this.status = status;
        this.thumbnail = thumbnail;
        this.briefinfo = briefinfo;
    }

    public String getBriefinfo() {
        return briefinfo;
    }

    public void setBriefinfo(String briefinfo) {
        this.briefinfo = briefinfo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BlogManagerDetailDTO{" + "id=" + id + ", title=" + title + ", categoryName=" + categoryName + ", content=" + content + ", status=" + status + '}';
    }
    
    
}
