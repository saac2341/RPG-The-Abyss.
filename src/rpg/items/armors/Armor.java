package rpg.items.armors;

import rpg.items.Equipment;

public abstract class Armor extends Equipment {

    protected ArmorType armorType;

    public Armor(String name, String description, int price, ArmorType armorType) {
        super();
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

}
