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
        PictureCache.addImage("Destroyer", "Enemies/New/Destroyer2.png");
    }

    public void getLoot(){
        System.out.println("Destroyer");
    }

    @Override
    protected void initCharacter() {
        this.name = "Destroyer";
        this.type= EnemyType.SECRET;
        this.stats.put(Stats.MAX_HP, 50); // Más vida que el Rookie Goblin
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 10); // Más ataque
        this.stats.put(Stats.DEFENSE, 5); // Más defensa
        this.stats.put(Stats.EXPERIENCE, 35);
        this.stats.put(Stats.GOLD, 20);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de atacar con barra oscura
        // 25% de probabilidad de atacar con explosion de fuego
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
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        String message = String.format(""" 
                ¡%s usa Fire Blast a %s por %d de daño! %s tiene %d HP restante.
                """);
        return message;
    }

    protected String darkSlash(GameCharacter enemy) throws EnemyDeathException {
        int damage = 5; // Daño un poco menor que el Fire Blast
        int newHP = reduceHP (enemy, damage);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        String message = String.format(""" 
                ¡%s usa sus garras con %s por %d de daño! %s tiene %d HP restante.
                """);
        return message;
    }
}
