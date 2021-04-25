package com.example.pokedex.controller;

import com.example.pokedex.service.PokedexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokedexController {
    @Autowired
    private PokedexService servico;

    @GetMapping("/")
  public ModelAndView getPokemons() {
	  ModelAndView mv = new ModelAndView("index");
        mv.addObject("pokemons", servico.getPokemons());
        return mv;
  }
}
