package rpg.items.armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.items.Equipment;

import java.util.HashMap;

/**
 * Craeción de la clase para las armaduras.
 */

public abstract class Armor extends Equipment{
    protected String name;
    protected String description;
    protected int price;
    protected ArmorType armorType;
    public Armor(String name) {

        super(name, "", 12, ItemType.ARMOR);
        this.name=name;
        this.description="";
        this.price=0;
        this.armorType=ArmorType.BOOTS;
    }
    protected abstract void initArmor();

    public String toString(){
        return "Armadura: "+name+" Descripción "+description+" Puntos: "+price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}


