package rpg.entities;
import rpg.enums.Stats;
import rpg.entities.Player;
import java.util.Map;
import java.util.HashMap;
import javax.swing.*;
/**
 * Creacion de la clase con sus atrivutos.
 */
public class Enemy {
    private String name;
    private Map<Stats,Integer>stats;

    /**
     * Constructor de los atributos iniciales muy paraecido a player.
     * @param name
     */
    public Enemy(String name){
        this.name=name;
        this.stats=new HashMap<>();
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
    }

    /**
     * Metodo para obtener el nombre del enemigo
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Merodo para obtener los atributos del enemigo
     */
    public Map<Stats, Integer> getStats() {
        return stats;
    }


    /**
     * Metodo para atacar a player.
     * @param player
     */
    public void attack(Player player) {
        int damage = this.stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " attacks " + player.getName() + " for " + damage + " damage!");
            JOptionPane.showMessageDialog(null,this.name + " ataca " + player.getName() + " por " + damage + " cuidado!");
        } else {
            System.out.println(this.name + " attacks " + player.getName() + " but does no damage!");
            JOptionPane.showMessageDialog(null,this.name + " ataques " + player.getName() + " no le esta haciendo daño!");
        }
    }
    /**
     * Sigues con vida?
     */
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }
}
