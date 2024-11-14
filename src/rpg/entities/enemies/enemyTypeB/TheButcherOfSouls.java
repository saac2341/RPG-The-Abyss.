package rpg.entities.enemies.enemyTypeB;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import javax.swing.*;

public class TheButcherOfSouls extends Enemy {
    public void getLoot(){

    }

    protected void intiCharacter(){
        this.name = "EL CARNICERO DE ALMAS";
        this.type= EnemyType.BOSS;
        this.stats.put(Stats.MAX_HP, 160);
        this.stats.put(Stats.HP, 160);
        this.stats.put(Stats.ATTACK, 15);
        this.stats.put(Stats.DEFENSE, 8);
    }
    public TheButcherOfSouls(){super("El CARNICERO DE ALMAS");}

    public void attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 3);
        switch (attack) {
            case 1:
                Tear(enemy);
                break;
            case 2:
                DarkFog(enemy);
                break;
            case 3:
                EatMeat(enemy);
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

    protected void Tear(GameCharacter enemy) {
        int damage = 7;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " desgarra a " + enemy.getName() + " menos " + damage + " puntos");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
    }

    protected void DarkFog(GameCharacter enemy) {
        int damage = 15;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " una niebla extraña te rodea y consume tus puntos de vida " + enemy.getName() + " menos " + damage + " puntos");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");

    }

    protected void EatMeat(GameCharacter enemy) {
        int damage = 30;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null,this.name + " devora la carne de " + enemy.getName() + " menos " + damage + " puntos");
        JOptionPane.showMessageDialog(null,enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
    }
}
