package rpg;
import rpg.enums.Stats;
import rpg.entities.Player;
import rpg.entities.Enemy;
import javax.swing.*;
import java.awt.*;

public class Game {
        private Player player;
        private Enemy enemy;

        /**
         * Ejecutos del programa del juego
         * @param args
         */
        public static void main(String[] args){

        }

        /**
         * Creacion de los objetos
         */
        public Game() {
            this.player = new Player("Mago");
            this.enemy = new Enemy("Goblin");
        }

        /**
         * Analiza quien a muerto en el juego
         */
        public void startGame() {
            while (player.isAlive() && enemy.isAlive()) {
                player.attack(enemy);
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            if (player.isAlive()) {
                JOptionPane.showMessageDialog(null, "Tu has matado al enemigo ");
            } else {
                JOptionPane.showMessageDialog(null,"Has perdido, el enemigo te a matado");
            }
        }
    }
