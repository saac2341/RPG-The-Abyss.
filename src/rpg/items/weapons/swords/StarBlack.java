package rpg.items.weapons.swords;

import rpg.enums.WeaponType;
import rpg.items.weapons.Weapon;

public abstract class StarBlack extends Weapon {
    /*
    Afrefa caracteristicas al arma.
     */
    public StarBlack(){
        super("Estrella negra","Un arma misteriosa forjads de un metal oscuro desconocido.", 2000, WeaponType.MYTHICAL);
    }

    @Override
    public String toString(){
        return "Nombre: " + name + ", Descripción: " + description + ", Precio: " + price;
    }

}
