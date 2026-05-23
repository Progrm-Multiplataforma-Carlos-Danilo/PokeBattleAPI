package com.pokebattle.controller.dto.request;

import java.util.List;

public record PokemonRequest(
        int id,
        String name,
        int hp,
        int attack,
        int defense,
        int specialAttack,
        int specialDefense,
        int speed,
        List<String> types,
        List<String> abilities,
        String spriteUrl,
        int height,
        int weight
) {
}