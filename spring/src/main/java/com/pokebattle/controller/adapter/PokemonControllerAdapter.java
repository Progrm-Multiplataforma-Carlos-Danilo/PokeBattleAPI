package com.pokebattle.controller.adapter;

import com.pokebattle.controller.dto.response.MoveResponse;
import com.pokebattle.controller.dto.response.PokemonResponse;
import com.pokebattle.entity.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonControllerAdapter {

    private PokemonControllerAdapter() {
    }

    public static PokemonResponse castResponse(Pokemon pokemon) {
        List<MoveResponse> moves = pokemon.moves() != null
                ? pokemon.moves().stream()
                    .map(m -> new MoveResponse(m.name(), m.power(), m.accuracy(),
                                               m.pp(), m.type(), m.damageClass()))
                    .collect(Collectors.toList())
                : List.of();

        return new PokemonResponse(
                pokemon.id(),
                pokemon.name(),
                pokemon.hp(),
                pokemon.attack(),
                pokemon.defense(),
                pokemon.specialAttack(),
                pokemon.specialDefense(),
                pokemon.speed(),
                pokemon.types() != null ? pokemon.types() : List.of(),
                pokemon.abilities() != null ? pokemon.abilities() : List.of(),
                moves,
                pokemon.spriteUrl(),
                pokemon.height(),
                pokemon.weight()
        );
    }

}
