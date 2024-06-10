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
public class PracticeListDTO {
    private int id;
    private String subjectName;
    private Date dateTaken;
    private int numberQuestion;
    private int numberCorrect;
    private int duration;

    public PracticeListDTO(int id, String subjectName, Date dateTaken, int numberQuestion, int numberCorrect, int duration) {
        this.id = id;
        this.subjectName = subjectName;
        this.dateTaken = dateTaken;
        this.numberQuestion = numberQuestion;
        this.numberCorrect = numberCorrect;
        this.duration = duration;
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

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PracticeListDTO{" + "id=" + id + ", subjectName=" + subjectName + ", dateTaken=" + dateTaken + ", numberQuestion=" + numberQuestion + ", numberCorrect=" + numberCorrect + ", duration=" + duration + '}';
    }
    
    
}
