package rpg.items.weapons.swords;
import rpg.enums.WeaponType;
import rpg.items.weapons.*;

public abstract class Sword extends Weapon{

    public Sword(String name, String descripcion, int price){
        super(name,descripcion,price,WeaponType.SWORD);
    }
    public String toString(){
        return "Espada"+ name+" descripcion de la espad"+ description+" puntos "+price;
    }


}

