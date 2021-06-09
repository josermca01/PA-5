package com.example.pokedex.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_LEARNMOVES")
public class LearnMoves implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long level;
    private String Name;
    private String Type;
    private String Category;
    private String Contest;
    private String Power;  
    private String Accuracy;   
    private String PP;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
        name = "TB_MOVES_POKEMON",
        joinColumns = @JoinColumn(name = "LEARNMOVE_ID"),
        inverseJoinColumns = @JoinColumn(name = "MOVESSET2_ID")
    )
    private List<Movesset2> movesset2s = new ArrayList<>();

    public LearnMoves(){

    }

    public LearnMoves(Moves move) {
        setName(move.getName());
        setType(move.getType());
        setCategory(move.getCategory());
        setContest(move.getContest());
        setPower(move.getPower());
        setAccuracy(move.getAccuracy());
        setPP(move.getPP());
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getLevel() {
        return level;
    }
    public void setLevel(Long level) {
        this.level = level;
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
    public List<Movesset2> getMovesset2s() {
        return movesset2s;
    }
    public void addMovesset2s(Movesset2 movesset2) {
        this.movesset2s.add(movesset2);
    }
    public void setMovesset2s(List<Movesset2> movesset2s) {
        this.movesset2s = movesset2s;
    }
    
}
