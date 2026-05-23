package com.pokebattle.entity;

public record Move(
        String name,
        int power,
        int accuracy,
        int pp,
        String type,
        String damageClass
) {}
    
