package com.example.pokedex.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MOVESSET")
public class Movesset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dexnum; 
    private String Level; 
    private String Move;
    private String Type;
    private String Cat; 
    private String Pwr;  
    private String Acc;   
    private int PP;

    public Long getDexnum() {
        return dexnum;
    }
    public void setDexnum(Long Dexnum) {
        dexnum = Dexnum;
    }
    public String getLevel() {
        return Level;
    }
    public void setLevel(String level) {
        Level = level;
    }
    public String getMove() {
        return Move;
    }
    public void setMove(String move) {
        Move = move;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getCat() {
        return Cat;
    }
    public void setCat(String cat) {
        Cat = cat;
    }
    public String getPwr() {
        return Pwr;
    }
    public void setPwr(String pwr) {
        Pwr = pwr;
    }
    public String getAcc() {
        return Acc;
    }
    public void setAcc(String acc) {
        Acc = acc;
    }
    public int getPP() {
        return PP;
    }
    public void setPP(int pP) {
        PP = pP;
    }
    
}  
