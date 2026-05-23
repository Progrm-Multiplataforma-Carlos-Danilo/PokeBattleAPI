package com.pokebattle.repository;

import com.pokebattle.entity.Pokemon;
import com.pokebattle.repository.adapter.PokemonRepositoryAdapter;
import com.pokebattle.repository.orm.PokemonOrmSupabase;
import com.pokebattle.repository.supabase.PokemonRepositoryWithSupabase;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonRepositoryWithSupabase repository;

    public PokemonRepositoryImpl(PokemonRepositoryWithSupabase repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Pokemon> findById(int id) {
        return repository.findById(id)
                .map(PokemonRepositoryAdapter::castOrm);
    }

    @Override
    public Optional<Pokemon> findByName(String name) {
        return repository.findByNameIgnoreCase(name)
                .map(PokemonRepositoryAdapter::castOrm);
    }

    @Override
    public List<Pokemon> findAll(int limit, int offset) {
        int page = (limit > 0) ? offset / limit : 0;
        return repository.findAll(PageRequest.of(page, limit))
                .stream()
                .map(PokemonRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pokemon> findByType(String type) {
        return repository.findByType(type).stream()
                .map(PokemonRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pokemon> findRandom(int count) {
        List<Integer> ids = repository.findRandomIds(count);
        return repository.findAllById(ids).stream()
                .map(PokemonRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) repository.count();
    }

}