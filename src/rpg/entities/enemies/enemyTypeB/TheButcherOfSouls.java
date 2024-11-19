package rpg.entities.enemies.enemyTypeB;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import rpg.utils.cache.PictureCache;
import rpg.exceptions.EnemyDeathException;

import javax.swing.*;

public class TheButcherOfSouls extends Enemy {

    public TheButcherOfSouls(){
        super("El CARNICERO DE ALMAS");
        PictureCache.addImage("Butcher_Souls","Enemies/New/AlmasF.png");
    }

    public void getLoot(){
        System.out.println("The Butcher of Souls drops all the gold of the fallen.");
    }

    @Override
    protected void initCharacter() {
        this.name = "EL CARNICERO DE ALMAS";
        this.type= EnemyType.BOSS;
        this.stats.put(Stats.MAX_HP, 160);
        this.stats.put(Stats.HP, 160);
        this.stats.put(Stats.ATTACK, 15);
        this.stats.put(Stats.DEFENSE, 8);
        this.stats.put(Stats.EXPERIENCE,100);
        this.stats.put(Stats.GOLD, 150);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        int random = Randomize.getRandomInt(1, 100);
        int attack = (random <= 50) ? 4 : (random <= 25) ? 3 : (random <= 65) ? 2 : 1;
        switch (attack) {
            case 1:
                try {
                    message = Tear (enemy);
                } catch ( EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Hermitaño lanza un golpe de sombra y hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = DarkFog(enemy);
                } catch ( EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Hermitaño lanza un golpe de sombra y hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 3:
                try {
                    message = EatMeat(enemy);
                } catch ( EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Hermitaño lanza un golpe de sombra y hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            default:
                message = ((GameCharacter)this).attack(enemy);
                break;
        }
        return message;
    }

    protected String Tear (GameCharacter enemy) throws EnemyDeathException{
        int damage = 7;
        int newHP = reduceHP (enemy, damage);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        String message = String.format(""" 
                ¡%s desgarra la piel de %s por %d de daño! %s tiene %d HP restante.
                """);
        return message;
    }

    protected String DarkFog(GameCharacter enemy) throws EnemyDeathException {
        int damage = 15;
        int newHP = reduceHP (enemy, damage);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        String message = String.format(""" 
                ¡%s invoca una niebla negra que consume la fuerza vital de %s por %d de daño! %s tiene %d HP restante.
                """);
        return message;
    }

    protected String EatMeat(GameCharacter enemy) throws EnemyDeathException{
        int damage = 30;
        int newHP = reduceHP (enemy, damage);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        String message = String.format(""" 
                ¡%s arranca la piel de %s por %d de daño! %s tiene %d HP restante.
                """);
        return message;
    }

    @Override
    public ImageIcon getSprite() {
        return PictureCache.getImageIcon("Butcher_Souls");
    }

}
