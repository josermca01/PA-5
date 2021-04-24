package com.example.pokedex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokedexController {
    @GetMapping("/")
  public String start() {
	  return "index";	
  }
}
