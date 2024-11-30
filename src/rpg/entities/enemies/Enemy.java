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

public abstract class Enemy extends GameCharacter {
    /*
    Esta clase d enemy se ocupa de administar los ataques y atibutos de los enemigos
    para luego mandarlos, ocupa como base la clase GameCharacter
     */
    protected EnemyType type;

    public Enemy(String name) {
        super(name);
    }
    public abstract void getLoot();

    public abstract String attack(GameCharacter enemy);

    public EnemyType getType(){
        return type;
    }
    public abstract ImageIcon getSprite();

    public void setName(String name){
        this.name = name;
    }
}