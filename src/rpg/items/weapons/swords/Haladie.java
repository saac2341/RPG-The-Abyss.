package rpg.items.weapons.swords;

import rpg.enums.WeaponType;
import rpg.items.weapons.Weapon;

public abstract class Haladie extends Weapon {
/*
Afrefa caracteristicas al arma.
 */
    public Haladie(){
        super("Haladie","Un arma antigua con dos hojas en ambos extremos.", 800, WeaponType.KNIFE);
    }

    @Override
    public String toString(){
        return "Nombre: " + name + ", Descripción: " + description + ", Precio: " + price;
    }

}
