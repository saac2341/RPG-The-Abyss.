package rpg.entities.enemies;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class IntermediateLince extends Enemy {
    public IntermediateLince(){
        super();
        this.name="Intermediate Lince";
        this.stats.put(Stats.MAX_MP,60);
        this.stats.put(Stats.HP,60);
        this.stats.put(Stats.ATTACK,12);
        this.stats.put(Stats.DEFENSE,5);
    }

    public void attack(GameCharacter enemy){
        int attack=Randomize.getRandomInt(1,2);
        switch (attack){
            case 1:
                clawStrike(enemy);
                break;
            case 2:
                tailWhip(enemy);
                break;
            case 3:
                roar(enemy);
                break;
            default:
                super.attack(enemy);
        }
    }

    protected void clawStrike(GameCharacter enemy) {
        int damage = 6;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " strikes " + enemy.getName() + " with its claws for " + damage + " damage!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void tailWhip(GameCharacter enemy) {
        int damage = 4;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " whips " + enemy.getName() + " with its tail for " + damage + " damage!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void roar(GameCharacter enemy) {
        int attackReduction = 2;
        enemy.getStats().put(Stats.ATTACK, enemy.getStats().get(Stats.ATTACK) - attackReduction);
        JOptionPane.showMessageDialog(null,this.name + " roars at " + enemy.getName() + ", reducing its attack by " + attackReduction + "!");
        JOptionPane.showMessageDialog(null,enemy.getName() + "'s attack is now " + enemy.getStats().get(Stats.ATTACK) + ".");
        }
    }

