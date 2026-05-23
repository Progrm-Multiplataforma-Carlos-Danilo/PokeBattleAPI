package com.pokebattle.controller;

import com.pokebattle.controller.adapter.PokemonControllerAdapter;
import com.pokebattle.controller.dto.response.PokemonResponse;
import com.pokebattle.repository.PokemonRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponse> findById(@PathVariable int id) {
        return pokemonRepository.findById(id)
                .map(PokemonControllerAdapter::castResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonResponse> findByName(@PathVariable String name) {
        return pokemonRepository.findByName(name)
                .map(PokemonControllerAdapter::castResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PokemonResponse> findAll(
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return pokemonRepository.findAll(limit, offset).stream()
                .map(PokemonControllerAdapter::castResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/type/{type}")
    public List<PokemonResponse> findByType(@PathVariable String type) {
        return pokemonRepository.findByType(type).stream()
                .map(PokemonControllerAdapter::castResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/random")
    public List<PokemonResponse> findRandom(@RequestParam(defaultValue = "6") int count) {
        return pokemonRepository.findRandom(count).stream()
                .map(PokemonControllerAdapter::castResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/count")
    public int count() {
        return pokemonRepository.count();
    }

}