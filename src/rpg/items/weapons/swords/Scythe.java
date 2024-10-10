package rpg.items.weapons.swords;

import rpg.enums.WeaponType;
import rpg.items.weapons.Weapon;

public abstract class Scythe extends Weapon {

    public Scythe (){
        super("Guadaña","Una guadaña para cosechar almas.", 1200, WeaponType.MYTHICAL);
    }

    @Override
    public String toString(){
        return "Nombre: " + name + ", Descripción: " + description + ", Precio: " + price;
    }

}
