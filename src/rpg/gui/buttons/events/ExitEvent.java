package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.gui.HomeInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitEvent implements ActionListener {

    private final HomeInterface game;

    public ExitEvent(HomeInterface game) {

        this.game = game;
    }

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
