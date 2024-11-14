package rpg.entities.enemies;

import rpg.entities.Game;
import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

import java.util.Map;
import java.util.HashMap;
import javax.swing.*;
import java.lang.Integer;
import javax.swing.Action;

/**
 * Creacion de la clase con sus atributos.
 */
public abstract class Enemy extends GameCharacter {
    protected EnemyType type;
    /**
     * Constructor de los atributos iniciales muy paraecido a player.
     */
    public Enemy(String name) {
        super(name);
    }
    public abstract void getLoot();

    public abstract void attack(GameCharacter enemy);

    public EnemyType getType(){
        return type;
    }
    public abstract ImageIcon getSprite();
}