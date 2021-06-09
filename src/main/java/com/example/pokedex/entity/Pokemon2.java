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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_POKEMONNOVO")
public class Pokemon2 implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imagem;

    private String types0;

    private String types1;

    private int total;

    private int hp;

    private int attack;

    private int defense;

    private int spatk;

    private int spdef;
    
    private int speed;

    private String ability0;

    private String ability1;

    private String hidden;

    public Pokemon2() {
    }
    
    public Pokemon2(Long id, String name, String imagem, String types0, String types1, int total, int hp, int attack, int defense,
            int spatk, int spdef, int speed, String ability0, String ability1, String hidden,
            List<Movesset2> movesset2s) {
        this.id = id;
        this.name = name;
        this.imagem = imagem;
        this.types0 = types0;
        this.types1 = types1;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spatk = spatk;
        this.spdef = spdef;
        this.speed = speed;
        this.ability0 = ability0;
        this.ability1 = ability1;
        this.hidden = hidden;
        this.movesset2s = movesset2s;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "Pokemon_id")
    private List<Movesset2> movesset2s = new ArrayList<>();
        
    public List<Movesset2> getMovesset2s() {
        return movesset2s;
    }


    public void addMovesset2s(Movesset2 movesset2) {
        this.movesset2s.add(movesset2);
    }


    public void setMovesset2s(List<Movesset2> movesset2s) {
        this.movesset2s = movesset2s;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTypes0() {
        return types0;
    }


    public void setTypes0(String types0) {
        this.types0 = types0;
    }


    public String getTypes1() {
        return types1;
    }


    public void setTypes1(String types1) {
        this.types1 = types1;
    }


    public String getAbility0() {
        return ability0;
    }


    public void setAbility0(String ability0) {
        this.ability0 = ability0;
    }


    public String getAbility1() {
        return ability1;
    }


    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }


    public String getHidden() {
        return hidden;
    }


    public void setHidden(String hidden) {
        this.hidden = hidden;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpatk() {
        return spatk;
    }

    public void setSpatk(int spatk) {
        this.spatk = spatk;
    }

    public int getSpdef() {
        return spdef;
    }

    public void setSpdef(int spdef) {
        this.spdef = spdef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
