package rpg.entities;

import rpg.enums.Stats;
import rpg.exceptions.ItemNotFoundException;
import rpg.inventory.Inventory;
import rpg.items.Item;
import rpg.items.miscs.Misc;
import rpg.utils.Randomize;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

/**
 * Creación de los atributos.
 */
public class Player extends GameCharacter implements Serializable {

    private final Inventory inventory;
    /**
     * Definicion del inventario inicial y algunos tributos del personaje.
     *
     */
    public Player(String name) {
        super(name);
        inventory = new Inventory(15);
    }
    /*
    Esta funcion serciora que se carge el personaje en el juego.
     */
    public static Player load(int slot) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream
                    ("files/save" + slot + ".dat"));
            Player player = (Player) in.readObject();
            in.close();
            return player;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading the game");
        }
        return null;
    }
    public boolean tryToFlee(){
        return Randomize.getRandomBolean();
    }
    /*
    Esta clase implementa las caracteristicas del personaje y atributos que va a tener.
     */
    @Override
    protected void initCharacter() {
        stats.put(Stats.LEVEL,1);
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.MAX_MP, 50);
        stats.put(Stats.MP, 50);
        stats.put(Stats.ATTACK, 20);
        stats.put(Stats.DEFENSE, 5);
        stats.put(Stats.EXPERIENCE, 0);
        stats.put(Stats.NEEDED_EXPERIENCE, 100);
        stats.put(Stats.GOLD, 0);
    }
    /*
    Esta clase se encarga de actualizar los atributos del jugador cuando sube de nivel
     */

    public void levelUp(){
        stats.put(Stats.LEVEL, stats.get(Stats.LEVEL) + 1);
        stats.put(Stats.MAX_HP, stats.get(Stats.MAX_HP) + Randomize.getRandomInt(5, 10));
        stats.put(Stats.HP, stats.get(Stats.MAX_HP));
        stats.put(Stats.MAX_MP, stats.get(Stats.MAX_MP) + Randomize.getRandomInt(2, 5));
        stats.put(Stats.MP, stats.get(Stats.MAX_MP));
        stats.put(Stats.ATTACK, stats.get(Stats.ATTACK) + Randomize.getRandomInt(1, 3));
        stats.put(Stats.DEFENSE, stats.get(Stats.DEFENSE) + Randomize.getRandomInt(1, 3));
        stats.put(Stats.NEEDED_EXPERIENCE, stats.get(Stats.NEEDED_EXPERIENCE) + 50);
        stats.put(Stats.EXPERIENCE, 0);

    }
    /*
    Esta clase se encarga de agregar items o cosas al personaje.
     */
    public void addItemToInventory(Item item) {
        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                boolean found = false;
                for (Item i : inventory.getMiscs()) {
                    if (i.getName().equals(misc.getName())) {
                        misc.increaseQuantity(1);
                        inventory.removeItem(i);
                        inventory.addItem(misc);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    inventory.addItem(item);
                }
            } else {
                inventory.addItem(item);
            }
        } else {
            inventory.addItem(item);
        }
    }
    /*
    Esta clase se encarga de quitar items al personaje que lleve en el inventario.
     */
    public void removeItemFromInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                for (Item i : inventory.getMiscs()) {
                    if (i.getName().equals(item.getName())) {
                        misc.decreaseQuantity(1);
                        if (misc.getQuantity() == 0) {
                            inventory.removeItem(i);
                        }
                        break;
                    }
                }
            } else {
                inventory.removeItem(item);
            }
        } else {
            inventory.removeItem(item);
        }
    }

    public void sellItem(Item item) {
        try {
            Item getItem = inventory.getItem(item);
            if (getItem instanceof Misc misc) {
                if (misc.isStackable()) {
                    if (misc.getQuantity() > 1) {
                        misc.decreaseQuantity(1);
                    } else {
                        inventory.removeItem(item);
                    }
                }
            } else {
                inventory.removeItem(getItem);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /*
    Esta clase salva el slot del jugador
     */
    public void save(int slot){
        try {
            ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("files/save"+ slot+".dat"));
            out.writeObject(this);
            out.close();;
            System.out.println("Gama saved");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error al salvar el juego");
        }
    }

    public void showInventory() {
        StringBuilder content = new StringBuilder("Inventory: \n");
        String format = """
                Name: %s, Price: %d
                Description: %s
                """;
        String formatQuantity = """
                Name: %s, Price: %d, Quantity: %d
                Description: %s
                """;
        for (Item item : inventory.getItems()) {
            if (item instanceof Misc misc) {
                if (misc.isStackable()) {
                    content.append(String.format(formatQuantity, item.getName(),
                            item.getPrice(), misc.getQuantity(), item.getDescription()));
                } else {
                    content.append(String.format(format, item.getName(), item.getPrice(),
                            item.getDescription()));
                }
            } else {
                content.append(String.format(format, item.getName(), item.getPrice(),
                        item.getDescription()));
            }
        }
        JOptionPane.showMessageDialog(null, content.toString());
    }

    public Inventory getInventory() {
        return inventory;
    }

}
