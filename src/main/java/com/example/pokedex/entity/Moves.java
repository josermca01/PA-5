package com.example.pokedex.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MOVES")
public class Moves implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Type;
    private String Category;
    private String Contest;
    private String Power;  
    private String Accuracy;   
    private String PP;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public String getContest() {
        return Contest;
    }
    public void setContest(String contest) {
        Contest = contest;
    }
    public String getPower() {
        return Power;
    }
    public void setPower(String power) {
        Power = power;
    }
    public String getAccuracy() {
        return Accuracy;
    }
    public void setAccuracy(String accuracy) {
        Accuracy = accuracy;
    }
    public String getPP() {
        return PP;
    }
    public void setPP(String pP) {
        PP = pP;
    }
    
}
