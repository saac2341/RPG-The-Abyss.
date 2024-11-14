package rpg.entities.enemies.enemyTypeA;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.cache.PictureCache;
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
        System.out.println("Hermit.");
    }
    protected void intiCharacter(){
        this.type = EnemyType.BASIC;
        this.name = "Hermit";
        this.stats.put(Stats.MAX_HP, 60); // Más vida que Destroyer
        this.stats.put(Stats.HP, 60);
        this.stats.put(Stats.ATTACK, 12); // Más ataque
        this.stats.put(Stats.DEFENSE, 7); // Más defensa
        this.stats.put(Stats.EXPERIENCE, 30);
        this.stats.put(Stats.GOLD, 15);
    }
    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de golpe de sombra
        // 25% de probabilidad de lanzar garra fantasma
        int attack = (random <= 50) ? 3 : (random <= 75) ? 2 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = shadowStrike(enemy);
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
                    message = phantomClaw(enemy);
                } catch ( EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Goblin novato muerde salvajemente y te hace 3 de daño.
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

    public ImageIcon getSprite(){
        return PictureCache.getImageIcon("hermit");
    }


    protected void shadowStrike(GameCharacter enemy) throws EnemyDeathException {
        int damage = 8; // Daño considerable para este ataque
        int newHP = reduceHP (enemy, damage);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        JOptionPane.showMessageDialog(null, this.name + " uses Shadow Strike on " + enemy.getName() + " for "
                + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void phantomClaw(GameCharacter enemy) throws EnemyDeathException {
        /**
         * Daño un poco menor que el Shadow Strike
         */
        int damage = 6;
        int newHP = reduceHP (enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format(""" 
                ¡%s El enemigo ataca a %s con garra Fantasma %d de daño ! %s tiene %d HP restante.
                """);
        return message;
    }
}