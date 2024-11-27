package rpg.entities.enemies.enemyTypeB;
import  rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import javax.swing.*;
import rpg.utils.cache.PictureCache;

public class Destroyer extends Enemy {
    public Destroyer () {

        super("Destroyer");
        PictureCache.addImage("Destroyer", "Enemies/New/DestroyerF.png");
    }

    public void getLoot(){
        System.out.println("Destroyer");
    }

    @Override
    protected void initCharacter() {
        this.name = "Destroyer";
        this.type= EnemyType.SECRET;
        this.stats.put(Stats.MAX_HP, 80);
        this.stats.put(Stats.HP, 80);
        this.stats.put(Stats.ATTACK, 18);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.EXPERIENCE, 55);
        this.stats.put(Stats.GOLD, 20);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        int random = Randomize.getRandomInt(1, 100);
        int attack = (random <= 50) ? 3 : (random <= 75) ? 2 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = fireBlast(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Destroyer ataca con explosion de fuego te hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = darkSlash(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Destroyer ataca con barra oscura te hace 3 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            default:
                message = ((GameCharacter) this).attack(enemy);
                break;
        }
        return message;
    }


    @Override
    public ImageIcon getSprite() {
        return PictureCache.getImageIcon("Destroyer");
    }

    protected String fireBlast(GameCharacter enemy) throws EnemyDeathException {
        int damage = 7; // Daño considerable para este ataque
        int newHP = reduceHP (enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format(""" 
                ¡%s usa Fire Blast a %s por %d de daño! %s tiene %d HP restante.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String darkSlash(GameCharacter enemy) throws EnemyDeathException {
        int damage = 5; // Daño un poco menor que el Fire Blast
        int newHP = reduceHP (enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format(""" 
                ¡%s usa sus garras con %s por %d de daño! %s tiene %d HP restante.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }
}
