package rpg.items.miscs;

import rpg.items.Item;

import java.io.Serializable;

/**
 * Creation de demás objetos.
 */
public abstract class Misc extends Item implements Serializable {

    protected boolean consumable;

    protected boolean stackable;
    protected int quantity;
    protected int maxQuantity;

    public Misc(){
        super();
        maxQuantity = 99;
    }

    public abstract void use ();

    public boolean isConsumable() {
        return consumable;
    }

    public boolean isStackable(){
        return stackable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
        if (quantity > maxQuantity){
            quantity = maxQuantity;
        }
    }

    public void decreaseQuantity(int amount) {
        quantity -= amount;
        if (quantity < 0) {
            quantity = 0;
        }
    }

}
