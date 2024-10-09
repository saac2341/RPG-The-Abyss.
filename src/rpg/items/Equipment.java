package rpg.items;

import rpg.entities.Player;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.interfaces.Equipable;

import java.util.HashMap;

public abstract class Equipment extends Item implements Equipable {

    protected HashMap<Stats, Integer> stats;

    public Equipment(String name, String description, int price, ItemType itemType) {
        super(name, description, price, itemType);
    }

    public void equip(Player player){

    }

    public void unequip(Player player){

    }

}
