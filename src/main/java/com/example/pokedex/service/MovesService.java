package com.example.pokedex.service;

import java.util.List;

import com.example.pokedex.entity.LearnMoves;
import com.example.pokedex.entity.Moves;
import com.example.pokedex.repository.LearnMovesRepository;
import com.example.pokedex.repository.MovesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovesService {
    @Autowired
    private MovesRepository repository;
    
    @Autowired
    private LearnMovesRepository repository2 ;

    public List<Moves> getMoves() {
        List<Moves> list = repository.findAll();
        return list;
    }
    public Moves getMovesById(Long id){
        return repository.findById(id).get();
    }
    public LearnMoves transform(Moves move,Long level){
        LearnMoves newmove = new LearnMoves(move);
        newmove.setLevel(level);
        return newmove;
    }
    public void update(Long id,LearnMoves newmove){
        LearnMoves move = repository2.getOne(id);
        move.setLevel(newmove.getLevel());
        move.setName(newmove.getName());
        move.setType(newmove.getType());
        move.setAccuracy(newmove.getAccuracy());
        move.setCategory(newmove.getCategory());
        move.setContest(newmove.getContest());
        move.setPP(newmove.getPP());
        move.setPower(newmove.getPower());
        repository2.save(move);
    }
}
