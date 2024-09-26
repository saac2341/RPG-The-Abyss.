import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.utils.Randomize;

public class TheButcherOfSouls {
    public TheButcherOfSouls() {
        super();
        this.name = "EL CARNICERO DE ALMAS";
        this.stats.put(Stats.MAX_HP, 160);
        this.stats.put(Stats.HP, 160);
        this.stats.put(Stats.ATTACK, 15);
        this.stats.put(Stats.DEFENSE, 30);
    }

    public void attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 4);
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
                super.attack(enemy);
                break;
        }
    }

    protected void Tear(GameCharacter enemy) {
        int damage = 7;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " desgarra a " + enemy.getName() + " menos " + damage + " puntos");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
    }

    protected void DarkFog(GameCharacter enemy) {
        int damage = 15;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " una niebla extraña te rodea y consume tus puntos de vida " + enemy.getName() + " menos " + damage + " puntos");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
    }

    protected void EatMeat(GameCharacter enemy) {
        int damage = 30;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " devora la carne de " + enemy.getName() + " menos " + damage + " puntos");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " puntos de vida.");
    }
}
