package rpg.entities.enemies.enemyTypeB;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class IntermediateLince extends Enemy {

    public void getLoot(){

    }
    protected void intiCharacter(){
        this.name="Lince";
        this.type= EnemyType.MEDIUM;
        this.stats.put(Stats.MAX_MP,60);
        this.stats.put(Stats.HP,60);
        this.stats.put(Stats.ATTACK,12);
        this.stats.put(Stats.DEFENSE,5);
    }

    public IntermediateLince(){super("Lince");}

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
                ((GameCharacter)this).attack(enemy);
                break;
        }
    }

    @Override
    public ImageIcon getSprite() {
        return null;
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

