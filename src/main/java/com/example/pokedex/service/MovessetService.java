package com.example.pokedex.service;

import java.util.List;

import com.example.pokedex.entity.Movesset;
import com.example.pokedex.repository.MovessetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovessetService {
    @Autowired
    private MovessetRepository repository;

    public List<Movesset>getMovesById(Long id){
        return repository.find(id);
    }
}
