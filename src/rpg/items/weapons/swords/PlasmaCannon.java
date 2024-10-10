package rpg.items.weapons.swords;

import rpg.enums.WeaponType;
import rpg.items.weapons.Weapon;

public abstract class PlasmaCannon extends Weapon {
    public PlasmaCannon() {
        super("Cañon de plasma","Un arama fututiste que dispara plasma", 1500, WeaponType.SPEAR);
    }

    @Override
    public String toString() {
        return "Nombre:" + name + ", Descripción: " + description + ", Precio: " + price;
    }
}
