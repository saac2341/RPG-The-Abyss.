package rpg.entities.enemies.enemyTypeB;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class IntermediateLince extends Enemy {

    public IntermediateLince(){
        super("Lince");
        PictureCache.addImage("Lince","Enemies/New/LinceF.png");
    }

    public void getLoot() { System.out.println("Lince");}


    @Override
    protected void initCharacter() {
        this.name="Lince";
        this.type= EnemyType.MEDIUM;
        this.stats.put(Stats.MAX_MP,90);
        this.stats.put(Stats.HP,90);
        this.stats.put(Stats.ATTACK,15);
        this.stats.put(Stats.DEFENSE,5);
        this.stats.put(Stats.EXPERIENCE,90);
        this.stats.put(Stats.GOLD, 30);
    }

    public String attack(GameCharacter enemy){
        String message;
        //Numero aleatorio.
        int random=Randomize.getRandomInt(1,100);
        //Probabilidades del ataque.
        int attack = (random <= 50) ? 4 : (random <= 25) ? 3 : (random <= 65) ? 2 : 1;
        switch (attack){
            case 1:
                try {
                    message=clawStrike(enemy);
                }catch (EnemyDeathException e){
                    enemy.getStats().put(Stats.HP,0);
                    message= """
                            Lince ataca con gudaña y te lasima con 6 de daño
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message=tailWhip(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP,0);
                    message= """
                            Lince te ataca con latigos de cadenas de hace 4 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 3:
                try {
                    message=roar(enemy);
                }catch (EnemyDeathException e){
                    enemy.getStats().put(Stats.HP,0);
                    message= """
                            Lince utiliza rugido te reduce 2 de ataque.
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

    @Override
    public ImageIcon getSprite() {
        return PictureCache.getImageIcon("Lince");
    }

    protected String clawStrike(GameCharacter enemy) throws EnemyDeathException {
        int damage = 6;
        int newHP=reduceHP(enemy,damage);
        String enemyName = enemy.getName();
        String message=String.format("""
                !%s usa claw strike a %s por %d daño! %s tienen %d HP restante.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String tailWhip(GameCharacter enemy) throws EnemyDeathException {
        int damage = 4;
        int newHP=reduceHP(enemy,damage);
        String enemyName = enemy.getName();
        String message=String.format("""
                !%s usa sus latigos para atacar a %s por %d daño! %s tienen %d HP restante.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String roar(GameCharacter enemy) throws EnemyDeathException {
        int damage = 2;
        int newHP = reduceHP(enemy,damage);
        String enemyName = enemy.getName();
        String message=String.format("""
                !%s usa sus rugido para atacar a %s por %d daño! %s tienen %d HP restante.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }
}

