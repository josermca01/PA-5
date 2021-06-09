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
@Table(name="TB_MOVESSET2")
public class Movesset2 implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "TB_MOVES_POKEMON",
        joinColumns = @JoinColumn(name = "MOVESSET2_ID"),
        inverseJoinColumns = @JoinColumn(name = "LEARNMOVE_ID")
    )
    private List<LearnMoves> moves = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<LearnMoves> getMoves() {
        return moves;
    }
    public void addMoves(LearnMoves move) {
        this.moves.add(move);
    }
    public void setMoves(List<LearnMoves> moves) {
        this.moves = moves;
    }
    
}
