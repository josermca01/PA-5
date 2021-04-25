package com.example.pokedex.repository;

import com.example.pokedex.entity.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokedexRepository  extends JpaRepository <Pokemon, Long>{
    
}
