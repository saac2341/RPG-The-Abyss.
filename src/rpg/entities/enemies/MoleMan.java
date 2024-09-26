package rpg.entities.enemies;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class MoleMan extends Enemy{
    public MoleMan(){
        super();
        this.name="Hombre Topo";
        this.stats.put(Stats.MAX_HP,15);
        this.stats.put(Stats.HP,10);
        this.stats.put(Stats.ATTACK,3);
        this.stats.put(Stats.DEFENSE,6);
    }

    public void attack(GameCharacter enemy){
        int attack=Randomize.getRandomInt(1,4);
        switch (attack){
            case 1:
                Scratch(enemy);
                break;
            case 2:
                Drill(enemy);
                break;
            default:
                super.attack(enemy);
                break;
        }
    }

    protected void Scratch(GameCharacter enemy) {
        int damage = 2;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " rasguña a " + enemy.getName() + " menos " + damage + " puntos");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
    }

    protected void Drill(GameCharacter enemy) {
        int damage = 5;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " golpea al enemigo como un taladro a " + enemy.getName() + " menos " + damage + " puntos");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
        }
    }
