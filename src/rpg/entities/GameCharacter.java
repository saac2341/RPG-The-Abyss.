package rpg.entities;
import rpg.enums.Stats;
import java.util.HashMap;
import javax.swing.*;
import rpg.entities.GameCharacter;
/**
 * Creacion de la clase.
 */
public abstract class GameCharacter {

    protected String name;
    protected HashMap<Stats,Integer>stats;

    //Constructor
    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        intiCharacter();
    }

    protected abstract void intiCharacter();

    //¿Oye estás vivo?
    public boolean isAlive(){
        return stats.get(Stats.HP)>0;
    }

    //Atacar al jugador.
    public void attack (GameCharacter enemy){
        String enemyName= enemy.getName();
        int damage =this.stats.get(Stats.ATTACK)-
                enemy.getStats().get(Stats.DEFENSE);
        int newHP=enemy.getStats().get(Stats.HP);
        if(damage>0){
            newHP=enemy.getStats().get(Stats.HP)-damage;
            enemy.getStats().put(Stats.HP,newHP);
            JOptionPane.showMessageDialog(null,this.name+" ataca por "+
                    enemyName+" por "+damage+" daño!");
            JOptionPane.showMessageDialog(null,enemyName+" tienes "+newHP+ " de vida");
        }else{
            JOptionPane.showMessageDialog(null,this.name+" ataca "+
                    enemyName+" pero no hace daño!");
            JOptionPane.showMessageDialog(null,this.name+" tienes "+newHP+" de vida");
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

}