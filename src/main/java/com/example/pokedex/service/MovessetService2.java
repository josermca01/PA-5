package com.example.pokedex.service;

import com.example.pokedex.entity.Movesset2;
import com.example.pokedex.repository.MovessetRepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovessetService2 {
    @Autowired
    private MovessetRepository2 repository;

    public Movesset2 getMovesById(Long id){
        return repository.findById(id).get();
    }
    public void salvar(Movesset2 movesset2){
        repository.save(movesset2);
    }
}
