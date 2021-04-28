package com.example.pokedex.service;

import java.util.List;

import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.repository.PokedexRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexService {
    @Autowired
    private PokedexRepository repository;

    public List<Pokemon> getPokemons(String types0,String name) {
        if(name.isEmpty())
        return repository.find(types0);
        else
        return repository.findbyname(name);
    }

    public Pokemon getPokemonById(Long id) {
        return repository.findById(id).get();
    }
}
