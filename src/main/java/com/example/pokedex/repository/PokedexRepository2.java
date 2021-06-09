package com.example.pokedex.repository;

import java.util.List;

import com.example.pokedex.entity.Pokemon2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PokedexRepository2  extends JpaRepository <Pokemon2, Long>{
    @Query("SELECT p FROM Pokemon2 p " + 
           "WHERE " +
           "((LOWER(p.types0)     LIKE   LOWER(CONCAT('%', :types0, '%')))  OR  "+
           "(LOWER(p.types1)     LIKE   LOWER(CONCAT('%', :types0, '%')))) AND "+
           "(LOWER(p.name)     LIKE   LOWER(CONCAT('%', :name, '%')))"
    )

    public List<Pokemon2> find(String types0,String name);
    
}
