package com.example.pokedex.service;

import java.util.List;

import com.example.pokedex.entity.Abilidade;
import com.example.pokedex.repository.AbilidadesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilidadesService {
    @Autowired
    private AbilidadesRepository repository;

    public List<Abilidade> getAbilidades() {
        List<Abilidade> list = repository.findAll();
        return list;
    }
}
