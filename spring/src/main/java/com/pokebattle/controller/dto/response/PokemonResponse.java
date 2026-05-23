package com.pokebattle.controller.dto.response;

import java.util.List;

public record PokemonResponse(
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
        List<MoveResponse> moves,
        String spriteUrl,
        int height,
        int weight
) {
}
