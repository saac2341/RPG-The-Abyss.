package rpg.items.armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.items.Equipment;

import java.util.HashMap;

public abstract class Armor extends Equipment{
    protected ArmorType armorType;
    protected String name;
    protected String descipcion;
    protected  int price;

    public Armor(String name) {
        initArmor();
        this.armorType = armorType;
        this.name = name;
        this.descipcion = descipcion;
        this.price = price;
    }
    protected abstract void initArmor();

    public ArmorType getArmorType() {
        return armorType;
    }
    public String toString(){
        return "Casco"+name+ "Descripcion: "+description+"puntos"+price;
    }
}


