package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class Hermit extends Enemy {

    public Hermit() {
        super();
        this.name = "Hermit";
        this.stats.put(Stats.MAX_HP, 60); // Más vida que Destroyer
        this.stats.put(Stats.HP, 60);
        this.stats.put(Stats.ATTACK, 12); // Más ataque
        this.stats.put(Stats.DEFENSE, 7); // Más defensa
    }

    @Override
    public void attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 2); // Elegir entre 2 ataques
        switch (attack) {
            case 1:
                shadowStrike(enemy);  // Ataque 1: Shadow Strike
                break;
            case 2:
                phantomClaw(enemy);  // Ataque 2: Phantom Claw
                break;
            default:
                super.attack(enemy);
                break;
        }
    }

    protected void shadowStrike(GameCharacter enemy) {
        int damage = 8; // Daño considerable para este ataque
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null, this.name + " uses Shadow Strike on " + enemy.getName() + " for "
                + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void phantomClaw(GameCharacter enemy) {
        int damage = 6; // Daño un poco menor que el Shadow Strike
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null, this.name + " slashes " + enemy.getName() + " with Phantom Claw for "
                + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }
}
