package rpg.entities.enemies;
import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class Destroyer extends Enemy {

    public Destroyer() {
        super();
        this.name = "Destroyer";
        this.stats.put(Stats.MAX_HP, 50); // Más vida que el Rookie Goblin
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 10); // Más ataque
        this.stats.put(Stats.DEFENSE, 5); // Más defensa
    }

    public void attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 2); // Elegir entre 2 ataques
        switch (attack) {
            case 1:
                fireBlast(enemy);  // Ataque 1: Fire Blast
                break;
            case 2:
                darkSlash(enemy);  // Ataque 2: Dark Slash
                break;
            default:
                super.attack(enemy);
                break;
        }
    }

    protected void fireBlast(GameCharacter enemy) {
        int damage = 7; // Daño considerable para este ataque
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " uses Fire Blast on " + enemy.getName() + " for "
                + damage + " damage!");
        JOptionPane.showMessageDialog(null,enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void darkSlash(GameCharacter enemy) {
        int damage = 5; // Daño un poco menor que el Fire Blast
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " slashes " + enemy.getName() + " with Dark Slash for "
                + damage + " damage!");
        JOptionPane.showMessageDialog(null,enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }
}