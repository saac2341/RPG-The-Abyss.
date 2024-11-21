package rpg.items;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.entities.Player;
import rpg.interfaces.Equipable;

import java.util.HashMap;

/**
 * Clase para equipar objetos al jugador.
 */

public abstract class Equipment extends Item implements Equipable{
    protected HashMap<Stats, Integer>stats;

    public Equipment(String name, String description, int price, ItemType itemType) {
        super(name);
    }

    public void equip(Player player){

    }

    public void unequip(Player player){

    }
}

