package com.pokebattle.repository.supabase;

import com.pokebattle.repository.orm.PokemonOrmSupabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepositoryWithSupabase extends JpaRepository<PokemonOrmSupabase, Integer> {

    Optional<PokemonOrmSupabase> findByNameIgnoreCase(String name);

    @Query("SELECT DISTINCT p FROM PokemonOrmSupabase p JOIN p.types t WHERE LOWER(t) = LOWER(:type)")
    List<PokemonOrmSupabase> findByType(@Param("type") String type);

    @Query(value = "SELECT id FROM pokemon ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Integer> findRandomIds(@Param("count") int count);

}
