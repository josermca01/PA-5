package com.example.pokedex.repository;

import java.util.List;

import com.example.pokedex.entity.Movesset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * MovessetRepository
 */
public interface MovessetRepository extends JpaRepository <Movesset, Long>{
    @Query("SELECT m FROM Movesset m " + 
           "WHERE " +
           "(m.dexnum = :dexnum )"
    )


    public List<Movesset> find(Long dexnum);
    
}