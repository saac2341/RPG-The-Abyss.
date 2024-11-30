package rpg.items;

import rpg.enums.ItemType;

/**
 * Creación de la clase de objetos.
 */

public abstract class Item {
    protected String name;
    protected String description;
    protected int price;
    protected ItemType itemType;
    public Item(String name){
        initItem();
        this.name=name;
    }
    public Item() {
    }
    protected abstract void initItem();
/*
Regresa parametos sobre el item a las clases que lo necesiten
 */
    public String getName(){
        return name;
    }
    public String getDescription(){
        return getDescription();
    }
    public int getPrice(){
        return getPrice();
    }
    public ItemType getItemType(){
        return itemType;
    }
}
