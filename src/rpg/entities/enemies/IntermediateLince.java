package rpg.entities.enemies;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class IntermediateLince extends Enemy {
    public IntermediateLince(){
        super();
        this.name="Lince";
        this.stats.put(Stats.MAX_MP,60);
        this.stats.put(Stats.HP,60);
        this.stats.put(Stats.ATTACK,12);
        this.stats.put(Stats.DEFENSE,5);
    }

    public void attack(GameCharacter enemy){
        int attack=Randomize.getRandomInt(1,3);
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
                break;
        }
    }

    protected void clawStrike(GameCharacter enemy) {
        int damage = 6;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " guadalla " + enemy.getName() + " lo lastima por " + damage + " daño!");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + "vida.");
    }

    protected void tailWhip(GameCharacter enemy) {
        int damage = 4;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " latigos " + enemy.getName() + " con cadenas " + damage + " daño!");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " vida.");
    }

    protected void roar(GameCharacter enemy) {
        int attackReduction = 2;
        enemy.getStats().put(Stats.ATTACK, enemy.getStats().get(Stats.ATTACK) - attackReduction);
        JOptionPane.showMessageDialog(null,this.name + " rugido " + enemy.getName() + ", reduciendo el ataque " + attackReduction + "!");
        JOptionPane.showMessageDialog(null,enemy.getName() + " ahora el ataca " + enemy.getStats().get(Stats.ATTACK) + ".");
        }
    }

