package rpg.items;

import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;

import java.util.ArrayList;
/*
Esta clase es la base para el inventario
 */
public class Inventory {

    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity){
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (items.size()< capacity){
            items.add(item);
        } else {
            System.out.println("El inventario está lleno");
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
        return items.size() == capacity;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clear(){
        items.clear();
    }

    public void increaseCapacity(int amount){
        capacity += amount;
        items.ensureCapacity(capacity);
    }

    public ArrayList<Armor> getArmor(){

        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items){
        }
        return armors;
    }

    public ArrayList<Misc> getMiscs(){

        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items){
        }
        return miscs;
    }

}
