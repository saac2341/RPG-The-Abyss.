package rpg.entities.enemies.enemyTypeA;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class Hermit extends Enemy {

    public Hermit() {
        super("Hermit");
        PictureCache.addImage("hermit","Enemies/New/Hermitaño2.png");
    }
    //Loot que lleva el enemigo el enemigo
    public void getLoot(){

    }

    protected void intiCharacter(){
        this.type = EnemyType.BASIC;
        this.name = "Hermit";
        this.stats.put(Stats.MAX_HP, 60); // Más vida que Destroyer
        this.stats.put(Stats.HP, 60);
        this.stats.put(Stats.ATTACK, 12); // Más ataque
        this.stats.put(Stats.DEFENSE, 7); // Más defensa
    }
    public ImageIcon getSprite(){
        return PictureCache.getImageIcon("hermit");
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
