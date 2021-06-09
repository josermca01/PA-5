package com.example.pokedex.service;

import java.util.List;

import com.example.pokedex.entity.LearnMoves;
import com.example.pokedex.entity.Movesset2;
import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.entity.Pokemon2;
import com.example.pokedex.repository.PokedexRepository;
import com.example.pokedex.repository.PokedexRepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexService {
    @Autowired
    private PokedexRepository repository;
    @Autowired
    private PokedexRepository2 repository2;

    public List<Pokemon> getPokemons(String types0,String name) {
        List<Pokemon> list = repository.find(types0, name);
        return list;
    }

    public Pokemon getPokemonById(Long id) {
        return repository.findById(id).get();
    }

    public List<Pokemon2> getPokemons2(String types0,String name) {
        List<Pokemon2> list = repository2.find(types0, name);
        return list;
    }

    public Pokemon2 getPokemonById2(Long id) {
        return repository2.findById(id).get();
    }

    public void salvar(Pokemon2 pokemon2){
        if(pokemon2.getAbility0().equalsIgnoreCase(pokemon2.getAbility1()))
        pokemon2.setAbility1("");
        if(pokemon2.getAbility0().equalsIgnoreCase(pokemon2.getHidden()))
        pokemon2.setHidden("");
        if(pokemon2.getAbility1().equalsIgnoreCase(pokemon2.getHidden()))
        pokemon2.setHidden("");
        if(pokemon2.getTypes0().equalsIgnoreCase(pokemon2.getTypes1())||pokemon2.getTypes1().equalsIgnoreCase(""))
        pokemon2.setTypes1(null);
        pokemon2.setTotal(pokemon2.getAttack()+pokemon2.getDefense()+pokemon2.getHp()+pokemon2.getSpatk()+pokemon2.getSpdef()+pokemon2.getSpeed());
        Movesset2 moves = new Movesset2();
        LearnMoves move = new LearnMoves();
        move.setType("");
        moves.setName("Moves by Level");
        pokemon2.addMovesset2s(moves);
        pokemon2.getMovesset2s().get(0).addMoves(move);
        repository2.save(pokemon2);
    }
}
