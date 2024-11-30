package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.gui.windows.HomeInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackEvent implements ActionListener {

    /**
     * Evento ligado a la pantalla principal, el cual le permite atacar al enemigo con el botón atacar.
     */

    private final HomeInterface game;

    /**
     * Variable de referencia del juego
     */
    public AttackEvent(HomeInterface game) {
        this.game = game;
    }

    /**
     *Ligamiento e impresión de texto sobe la batalla entre el enemigo y el jugador
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Enemy enemy = this.game.getEnemy();
        Player player = this.game.getPlayer();
        if (enemy != null) {

            this.game.appendText(player.attack(enemy));
            if (enemy.isAlive())
                this.game.appendText(enemy.attack(player));
            this.game.checkGameStatus();
        }
    }
}
