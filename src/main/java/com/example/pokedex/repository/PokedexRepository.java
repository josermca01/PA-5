package com.example.pokedex.repository;

import java.util.List;

import com.example.pokedex.entity.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PokedexRepository  extends JpaRepository <Pokemon, Long>{
    @Query("SELECT p FROM Pokemon p " + 
           "WHERE " +
           "(LOWER(p.types0)     LIKE   LOWER(CONCAT('%', :types0, '%')))  OR  "+
           "(LOWER(p.types1)     LIKE   LOWER(CONCAT('%', :types0, '%'))) OR "+
           "(LOWER(p.name)     LIKE   LOWER(CONCAT('%', :types0, '%')))"
    )

    public List<Pokemon> find(String types0);
}
