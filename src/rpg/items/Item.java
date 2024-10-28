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
        this.description=description;
        this.price=price;
        this.itemType=itemType;

    }

    public Item() {

    }

    protected abstract void initItem();

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
