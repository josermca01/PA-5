package com.example.pokedex.repository;

import com.example.pokedex.entity.Moves;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovesRepository extends JpaRepository <Moves, Long>{
    
}
