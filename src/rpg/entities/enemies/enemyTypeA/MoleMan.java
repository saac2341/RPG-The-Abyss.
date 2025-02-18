package rpg.entities.enemies.enemyTypeA;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class MoleMan extends Enemy {
    /*
    Esta clase se le apregar el nombre al personaje al igual que la imagen que va a llevar
     */
    public MoleMan() {
        super("Hombre Topo");
        PictureCache.addImage("Hombre_Topo", "Enemies/New/TopoF.png");
    }

    public void getLoot() {
        System.out.println("The Mole Man drops a gold stone.");
    }
    /*
    Esta clase se ocupa de los atributos del personaje
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP,50);
        this.stats.put(Stats.HP,50);
        this.stats.put(Stats.ATTACK,8);
        this.stats.put(Stats.DEFENSE,6);
        this.stats.put(Stats.EXPERIENCE,30);
        this.stats.put(Stats.GOLD, 30);
    }
    /*
    Administra los ataques del personaje de forma aleatoria
     */
    public String attack(GameCharacter enemy){
        String message;
        int random = Randomize.getRandomInt(1,100);
        int attack = (random <= 50) ? 3 : (random <= 75) ? 2 : 1;
        switch (attack){
            case 1:
                try {
                    message = Scratch(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Hombre Topo te rasguña y te hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = Drill(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Hombre Topo gira como un tralado y te hace 5 de daño.
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
    /*
    Cosas que hacen cada tipo de ataque al jugador
     */
    protected String Scratch(GameCharacter enemy) throws EnemyDeathException {
        int damage = 5;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s rasguña a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String Drill(GameCharacter enemy) throws EnemyDeathException {
        int damage = 7;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s golpea como un taladro a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {
        return PictureCache.getImageIcon("Hombre_Topo");
    }

}