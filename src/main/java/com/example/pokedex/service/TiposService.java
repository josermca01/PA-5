package com.example.pokedex.service;

import java.util.List;

import com.example.pokedex.entity.Tipos;
import com.example.pokedex.repository.TiposRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposService {
    @Autowired
    private TiposRepository repository;

    public List<Tipos> getTipos() {
        List<Tipos> list = repository.findAll();
        return list;
    }
}
