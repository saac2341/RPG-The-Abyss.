package rpg.inventory;

import rpg.items.Item;
import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;
import rpg.items.weapons.Weapon;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase que representará el inventario de un personaje.
 */

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity){
        this.capacity=capacity;
        items=new ArrayList<>();
    }
    public void addItem(Item item){
        if (items.size()<capacity){
            items.add(item);
        }else{
            JOptionPane.showMessageDialog(null,"Inventario lleno");
        }
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public Item getItem(int index){
        return items.get(index);
    }
    public void getItemCount(){
        items.size();
    }
    public boolean isFull(){
        return items.size()==capacity;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void increaseCapacity(int amount){
        capacity +=amount;
        items.ensureCapacity(capacity);
    }
    public ArrayList<Armor> getArmors() {
        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }
    public ArrayList<Misc>getMiscs(){

        ArrayList<Misc>miscs=new ArrayList<>();
        for (Item item:items){
            if (item instanceof Misc){
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }

    public ArrayList<Weapon> getWeapons() {
        ArrayList<Weapon> weapons=new ArrayList<>();
        for (Item item:items){
            if (item instanceof Weapon){
                weapons.add((Weapon) item);
            }
        }
        return weapons;
    }
}
