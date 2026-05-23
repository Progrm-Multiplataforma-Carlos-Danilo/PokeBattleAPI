package com.pokebattle.entity;

import java.util.List;


public record Pokemon(
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
        List<Move> moves,
        String spriteUrl,
        int height,
        int weight
) {


}
