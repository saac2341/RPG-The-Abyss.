package rpg.inventory;
import javax.swing.*;

import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;

public class InventoryTest {
    public class Main{
        public static void main(String[] args){
            Inventory inventory=new Inventory(10);

            /**
             * Agregar armas.
             */

            /**
             * argregar armaduras.
             */

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
