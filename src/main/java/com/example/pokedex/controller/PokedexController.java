package com.example.pokedex.controller;

import com.example.pokedex.entity.LearnMoves;
import com.example.pokedex.entity.Moves;
import com.example.pokedex.entity.Movesset2;
import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.entity.Pokemon2;
import com.example.pokedex.service.AbilidadesService;
import com.example.pokedex.service.MovesService;
import com.example.pokedex.service.MovessetService;
import com.example.pokedex.service.MovessetService2;
import com.example.pokedex.service.PokedexService;
import com.example.pokedex.service.TiposService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class PokedexController {
    @Autowired
    private PokedexService servico;

    @Autowired
    private MovessetService servicomovesset;

    @Autowired
    private MovessetService2 servicomovesset2;

    @Autowired
    private MovesService servicomoves;

    @Autowired
    private TiposService servicotipos;

    @Autowired
    private AbilidadesService servicoabilidades;

    @GetMapping("/")
  public ModelAndView getPokemons(@RequestParam(value = "types0",defaultValue = "") String types0,@RequestParam(value = "name",defaultValue = "") String name) {
	  ModelAndView mv = new ModelAndView("index");
        mv.addObject("pokemons", servico.getPokemons(types0.trim(),name.trim()));
        mv.addObject("pokemonsnovo", servico.getPokemons2(types0.trim(),name.trim()));
        mv.addObject("id",Long.valueOf(servico.getPokemons("","").size()));
        return mv;
  }
    @GetMapping("/pokemon/{id}")
  public ModelAndView getPokemon( @PathVariable(name = "id") Long id ) {
      
      Pokemon pokemon = servico.getPokemonById(id);
      ModelAndView mv = new ModelAndView("pokemon");
      mv.addObject("pokemon", pokemon);
      mv.addObject("moves", servicomovesset.getMovesById(id));
      return mv;
  }
  @GetMapping("/addpokemon")
  public ModelAndView addPokemon() {
    ModelAndView mv = new ModelAndView("addpokemon");
    mv.addObject("abilidades", servicoabilidades.getAbilidades());
    mv.addObject("tipos", servicotipos.getTipos());
    mv.addObject("pokemon", new Pokemon2());
    return mv;
}
  @RequestMapping(value = "/savePokemon",method = RequestMethod.POST)
  public RedirectView savePokemon(@ModelAttribute Pokemon2 pokemon2) {
      servico.salvar(pokemon2);
      return new RedirectView("/");
  }
  @RequestMapping(value = "/saveMove",method = RequestMethod.POST)
  public RedirectView saveMove(@ModelAttribute Moves move ,Long level , @RequestParam Long idmovesset,Long pokemonid) {
      Movesset2 movesset2 = servicomovesset2.getMovesById(idmovesset);
      Moves moves = servicomoves.getMovesById(move.getId());
      LearnMoves newmove = servicomoves.transform(moves, level);
      if(movesset2.getMoves().get(0).getType().equalsIgnoreCase("")){
        servicomoves.update(movesset2.getMoves().get(0).getId(),newmove);
        return new RedirectView("/pokemonnovo/"+pokemonid+"");
      }
      movesset2.getMoves().add(newmove);
      servicomovesset2.salvar(movesset2);
      return new RedirectView("/pokemonnovo/"+pokemonid+"");
  }
  @GetMapping("/pokemonnovo/{id}")
  public ModelAndView getPokemonnovo( @PathVariable(name = "id") Long id ) {
      
      Pokemon2 pokemon2 = servico.getPokemonById2(id);
      ModelAndView mv = new ModelAndView("pokemonnovo");
      mv.addObject("pokemon", pokemon2);
      mv.addObject("id",Long.valueOf(servico.getPokemons("","").size()));
      mv.addObject("moves", servicomoves.getMoves());
      return mv;
  }
}
