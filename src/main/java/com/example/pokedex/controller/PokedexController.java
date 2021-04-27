package com.example.pokedex.controller;

import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.service.MovessetService;
import com.example.pokedex.service.PokedexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokedexController {
    @Autowired
    private PokedexService servico;

    @Autowired
    private MovessetService servicomoves;

    @GetMapping("/")
  public ModelAndView getPokemons(@RequestParam(value = "types0",defaultValue = "") String types0) {
    HttpHeaders header = new HttpHeaders();
    header.add("desc", "List of pokemon by type");
    header.add("type", "pokemon object");
	  ModelAndView mv = new ModelAndView("index");
        mv.addObject("pokemons", servico.getPokemons(types0.trim()));
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(mv).getBody();
  }
    @GetMapping("/pokemon/{id}")
  public ModelAndView getPokemon( @PathVariable(name = "id") Long id ) {
      
      Pokemon pokemon = servico.getPokemonById(id);
      ModelAndView mv = new ModelAndView("pokemon");
      mv.addObject("pokemon", pokemon);
      mv.addObject("moves", servicomoves.getMovesById(id));
      return mv;
  }
}
