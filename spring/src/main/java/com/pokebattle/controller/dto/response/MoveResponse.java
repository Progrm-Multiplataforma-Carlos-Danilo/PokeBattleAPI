package com.pokebattle.controller.dto.response;

public record MoveResponse(
        String name,
        int power,
        int accuracy,
        int pp,
        String type,
        String damageClass
) {
}
