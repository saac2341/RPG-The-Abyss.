package rpg.inventory;
import javax.swing.*;

import rpg.items.armors.Armaduras.*;
import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;
import rpg.items.miscs.Posion;

public class InventoryTest {
    public static class  Main{
        public static void main(String[] args){
            Inventory inventory=new Inventory(10);

            /**
             * Agregar armas.
             */
            Armor armor;
            armor = new Armor1() {
                @Override
                protected void initItem() {

                }
            };

            inventory.addItem(armor);
            /**
             * argregar armaduras.
             */
            Misc misc=new Posion();
            inventory.addItem(misc);

            //Imprimir las armas del inventario.
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
