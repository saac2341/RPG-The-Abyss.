package rpg.items.armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.items.Equipment;

import java.util.HashMap;

public abstract class Armor extends Equipment{
    protected String name;
    protected String descipcion;
    protected  int price;
    protected ArmorType armorType;

    public Armor(String name){
        this.name=name;

    }
    protected abstract void initArmor();

    public ArmorType getArmorType() {
        return armorType;
    }
    public String toString(){
        return "Casco"+name+ "Descripcion: "+description+"puntos"+price;
    }
}


