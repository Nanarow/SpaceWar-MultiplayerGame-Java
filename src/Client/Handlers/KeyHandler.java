package Client.Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Client.Entities.MainPlayer;
import Client.UI.PlayPanel;

public class KeyHandler implements KeyListener{
    private PlayPanel playPanel;
    private MainPlayer player;
    
    public KeyHandler(PlayPanel playPanel, MainPlayer player) {
        this.playPanel = playPanel;
        this.player = player;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyAction(e.getKeyCode(),true);
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            playPanel.getSettingPanel().setVisible(!playPanel.getSettingPanel().isVisible());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyAction(e.getKeyCode(),false);
    }
    private void keyAction(int keyCode,boolean keyPressed){
        if (keyCode == KeyEvent.VK_W) {
            player.setUpPressed(keyPressed);
        }
        if (keyCode == KeyEvent.VK_S) {
            player.setDownPressed(keyPressed);
        }
        if (keyCode == KeyEvent.VK_A) {
            player.setLeftPressed(keyPressed);
        }
        if (keyCode == KeyEvent.VK_D) {
            player.setRightPressed(keyPressed);
        }
        if (keyCode == KeyEvent.VK_Q) {
            player.setTriPressed(keyPressed);
        }
        if (keyCode == KeyEvent.VK_X) {
            player.setMissilePressed(keyPressed);
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            player.setDashPressed(keyPressed);
        }
    
    }


    
}
