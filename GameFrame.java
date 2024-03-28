import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame  implements MouseMotionListener {
    GamePanel gPanel;

    public GameFrame(){
        setBackground(Color.PINK);
        gPanel = new GamePanel();
        add(gPanel);
        setTitle("Score: " + gPanel.ship.getScore() + " Life: " + gPanel.ship.getLife());
        addMouseMotionListener(this);
        setVisible(true);
        setSize(800, 800);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        gPanel.ship.setPosition(mouseX, mouseY);
        setTitle("Score: " + gPanel.ship.getScore() + " Life: " + gPanel.ship.getLife());
        repaint();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
}