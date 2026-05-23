package com.pokebattle.repository.adapter;

import com.pokebattle.entity.Move;
import com.pokebattle.entity.Pokemon;
import com.pokebattle.repository.orm.MoveOrmSupabase;
import com.pokebattle.repository.orm.PokemonOrmSupabase;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonRepositoryAdapter {

    private PokemonRepositoryAdapter() {
    }

    public static Pokemon castOrm(PokemonOrmSupabase orm) {
        List<Move> moves = orm.getMoves() != null
                ? orm.getMoves().stream()
                    .map(m -> new Move(m.getName(), m.getPower(), m.getAccuracy(),
                                      m.getPp(), m.getType(), m.getDamageClass()))
                    .collect(Collectors.toList())
                : List.of();

        return new Pokemon(
                orm.getId(),
                orm.getName(),
                orm.getHp(),
                orm.getAttack(),
                orm.getDefense(),
                orm.getSpecialAttack(),
                orm.getSpecialDefense(),
                orm.getSpeed(),
                orm.getTypes() != null ? orm.getTypes() : List.of(),
                orm.getAbilities() != null ? orm.getAbilities() : List.of(),
                moves,
                orm.getSpriteUrl(),
                orm.getHeight(),
                orm.getWeight()
        );
    }

    public static PokemonOrmSupabase castEntity(Pokemon entity) {
        List<MoveOrmSupabase> moves = entity.moves() != null
                ? entity.moves().stream()
                    .map(m -> new MoveOrmSupabase(m.name(), m.power(), m.accuracy(),
                                                  m.pp(), m.type(), m.damageClass()))
                    .collect(Collectors.toList())
                : List.of();

        return new PokemonOrmSupabase(
                entity.id(),
                entity.name(),
                entity.hp(),
                entity.attack(),
                entity.defense(),
                entity.specialAttack(),
                entity.specialDefense(),
                entity.speed(),
                entity.types() != null ? entity.types() : List.of(),
                entity.abilities() != null ? entity.abilities() : List.of(),
                moves,
                entity.spriteUrl(),
                entity.height(),
                entity.weight()
        );
    }

}
