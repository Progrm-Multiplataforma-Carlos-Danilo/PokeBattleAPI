package com.pokebattle.repository.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MoveOrmSupabase {

    private String name;

    private int power;

    private int accuracy;

    private int pp;

    @Column(name = "move_type")
    private String type;

    @Column(name = "damage_class")
    private String damageClass;

    protected MoveOrmSupabase() {
    }

    public MoveOrmSupabase(String name, int power, int accuracy, int pp,
                            String type, String damageClass) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.type = type;
        this.damageClass = damageClass;
    }

    public String getName() { return name; }
    public int getPower() { return power; }
    public int getAccuracy() { return accuracy; }
    public int getPp() { return pp; }
    public String getType() { return type; }
    public String getDamageClass() { return damageClass; }

}
