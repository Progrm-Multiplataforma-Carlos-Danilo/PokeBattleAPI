package com.pokebattle.repository.orm;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemon")
public class PokemonOrmSupabase {

    @Id
    private int id;

    private String name;

    private int hp;

    private int attack;

    private int defense;

    @Column(name = "special_attack")
    private int specialAttack;

    @Column(name = "special_defense")
    private int specialDefense;

    private int speed;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "type")
    @OrderColumn(name = "type_order")
    private List<String> types;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "pokemon_abilities", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "ability")
    @OrderColumn(name = "ability_order")
    private List<String> abilities;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "pokemon_moves", joinColumns = @JoinColumn(name = "pokemon_id"))
    @OrderColumn(name = "move_order")
    private List<MoveOrmSupabase> moves;

    @Column(name = "sprite_url")
    private String spriteUrl;

    private int height;

    private int weight;

    protected PokemonOrmSupabase() {
    }

    public PokemonOrmSupabase(int id, String name, int hp, int attack, int defense,
                               int specialAttack, int specialDefense, int speed,
                               List<String> types, List<String> abilities,
                               List<MoveOrmSupabase> moves, String spriteUrl,
                               int height, int weight) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.types = types;
        this.abilities = abilities;
        this.moves = moves;
        this.spriteUrl = spriteUrl;
        this.height = height;
        this.weight = weight;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpecialAttack() { return specialAttack; }
    public int getSpecialDefense() { return specialDefense; }
    public int getSpeed() { return speed; }
    public List<String> getTypes() { return types; }
    public List<String> getAbilities() { return abilities; }
    public List<MoveOrmSupabase> getMoves() { return moves; }
    public String getSpriteUrl() { return spriteUrl; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }

}