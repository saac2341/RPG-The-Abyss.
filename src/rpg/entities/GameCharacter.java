package rpg.entities;
import rpg.enums.Stats;
import java.util.HashMap;
import javax.swing.*;
/**
 * Creacion de la clase.
 */
public class GameCharacter {
    protected String name;
    protected HashMap<Stats,Integer>stats;

    //Constructor
    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }
    //Oye estas vivo?
    public boolean isAlive(){
        return stats.get(Stats.HP)>0;
    }

    //Atacar al jugador.
    public void attack (GameCharacter enemy){
        String enemyName= enemy.getName();
        int damage =this.stats.get(Stats.ATTACK)-
                enemy.getStats().get(Stats.HP);
        int newHP=enemy.getStats().get(Stats.HP);
        if(damage>0){
            newHP=enemy.getStats().get(Stats.HP)-damage;
            enemy.getStats().put(Stats.HP,newHP);
        }else{
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}