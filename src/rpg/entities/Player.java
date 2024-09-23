package rpg.entities;
import javax.swing.*;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;
/**
 * Creación de los atributos.
 */
public class Player {
    private String name;
    private Map<Stats, Integer> stats;

    /**
     * Deffinición de los atributos.
     *
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    /**
     * Constructor que inicializa el nombre y los atributos del jugador
     */
    public Player() {
        this.name = getName();
    }

    // Método para obtener el nombre del jugador
    public String getName() {
        return name;
    }

    // Método para verificar si el jugador está vivo
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    // Método para atacar a un enemigo
    public void attack(Enemy enemy) {
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            int enemyHp = enemy.getStats().get(Stats.HP);
            enemy.getStats().put(Stats.HP, enemyHp - damage);
            JOptionPane.showMessageDialog(null, this.name + " ataca a " + enemy.getName() + " menos " + damage + " puntos");
        } else {
            JOptionPane.showMessageDialog(null, this.name + " attacks " + enemy.getName() + " but does no damage!");
        }
    }

    public Map<Stats, Integer> getStats() {
        return stats;
    }
}
