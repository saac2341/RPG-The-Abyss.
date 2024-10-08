package rpg.entities;

import javax.swing.*;

import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;

/**
 * Creación de los atributos.
 */
public class Player extends GameCharacter{
    /**
     * Deffinición de los atributos.
     *
     * @param name
     */
    public Player(String name) {
        super(name);
    }
    protected void intiCharacter(){
    //Implementacion de de la clase abstracta
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }
}
