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
        String messenger = "";
        String enemyName= enemy.getName();
        int damage =this.stats.get(Stats.ATTACK)-
                enemy.getStats().get(Stats.HP);
        int newHP=enemy.getStats().get(Stats.HP);
        if(damage>0){
            newHP=enemy.getStats().get(Stats.HP)-damage;
            enemy.getStats().put(Stats.HP,newHP);
            messenger = messenger + String.format("""
                            %s Ataques %s por %d daño!
                            %s tiene %d HP.
                            """, this.name, enemyName, damage,
                    enemyName, newHP);
        }else{
            messenger += String.format("""
                    %s ataca %s pero no hace daño!
                    %s tiene %d HP.
                    """,this.name,enemyName,enemy,newHP);
        }
        JOptionPane.showMessageDialog(null,messenger);
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}