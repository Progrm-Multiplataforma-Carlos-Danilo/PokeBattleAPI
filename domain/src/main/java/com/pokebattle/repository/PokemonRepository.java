package com.pokebattle.repository;

import com.pokebattle.entity.Pokemon;

import java.util.List;
import java.util.Optional;

/**
 * Contrato do repositório de Pokémon.
 * Define as operações de acesso a dados necessárias para o jogo de batalha.
 * A implementação concreta (ex: chamada à PokeAPI) ficará na camada de infraestrutura.
 */
public interface PokemonRepository {

    /**
     * Busca um Pokémon pelo seu ID da Pokédex.
     *
     * @param id identificador do Pokémon
     * @return o Pokémon encontrado, ou vazio se não existir
     */
    Optional<Pokemon> findById(int id);

    /**
     * Busca um Pokémon pelo nome (case-insensitive).
     *
     * @param name nome do Pokémon
     * @return o Pokémon encontrado, ou vazio se não existir
     */
    Optional<Pokemon> findByName(String name);

    /**
     * Lista todos os Pokémon disponíveis para batalha.
     *
     * @param limit  quantidade máxima de resultados
     * @param offset deslocamento para paginação
     * @return lista paginada de Pokémon
     */
    List<Pokemon> findAll(int limit, int offset);

    /**
     * Busca todos os Pokémon de um determinado tipo.
     *
     * @param type tipo do Pokémon (ex: "fire", "water")
     * @return lista de Pokémon do tipo informado
     */
    List<Pokemon> findByType(String type);

    /**
     * Retorna uma lista de Pokémon aleatórios para montar um time de batalha.
     *
     * @param count quantidade de Pokémon desejados
     * @return lista com Pokémon aleatórios
     */
    List<Pokemon> findRandom(int count);

    /**
     * Retorna a quantidade total de Pokémon disponíveis.
     *
     * @return total de Pokémon
     */
    int count();
}
