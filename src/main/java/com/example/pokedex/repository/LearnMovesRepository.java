package com.example.pokedex.repository;

import com.example.pokedex.entity.LearnMoves;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnMovesRepository extends JpaRepository <LearnMoves, Long>{
    
}
