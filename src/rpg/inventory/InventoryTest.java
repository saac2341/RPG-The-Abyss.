package rpg.inventory;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import rpg.items.armors.Armaduras.*;
import rpg.items.armors.Armor;
import rpg.items.miscs.DefensePotion;
import rpg.items.miscs.Misc;
import rpg.items.miscs.Posion;
import rpg.items.weapons.Weapon;
import rpg.items.weapons.swords.Haladie;
import rpg.items.weapons.swords.PlasmaCannon;

public class InventoryTest {
    public static class  Main{
        public static void main(String[] args){
            Inventory inventory=new Inventory(10);

            /**
             * Agregar armaduras.
             */
            Armor armor;
            armor = new Armor1() {
                @Override
                protected void initItem() {
                }
            };
            inventory.addItem(armor);
            Misc misc=new DefensePotion() {
            };
            inventory.addItem(misc);

            /**
             * Agregar espadas.
             */

            Weapon weapon;
            weapon= new Haladie() {
                @Override
                protected void initItem() {
                }
            };
            inventory.addItem(weapon);

            /**
             * Imprimir la espada al inventario.
             */

            JOptionPane.showMessageDialog(null,"La espada que lleva el jugador es:");
            for (Weapon w:inventory.getWeapons()){
                JOptionPane.showMessageDialog(null,w.getName());
            }

            /**
             * Imprimir la armadura al inventario.
             */

            JOptionPane.showMessageDialog(null,"Armadura del inventario");
            for (Armor a: inventory.getArmors()){

                JOptionPane.showMessageDialog(null, a.getName());
            }
            JOptionPane.showMessageDialog(null,"Demas objetos");
            for (Misc m: inventory.getMiscs()){
                JOptionPane.showMessageDialog(null, m.getName());
            }
        }
    }
}
