import java.awt.*;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{
    protected Ship ship;
    boolean control;
    protected ArrayList<InteractableDrawing> listOfDraw;
    private Timer timer;
    private int delay = 100;
    public GamePanel(){
        setBackground(Color.PINK);
        control = true;
        ship = new Ship();
        listOfDraw = new ArrayList<InteractableDrawing>();
        setPreferredSize(new Dimension(800, 800));
        timer = new Timer(delay, this);
        timer.start();
    }

    protected void createDrawing(){

        Random random = new Random();
        int randomNumber = random.nextInt(2);
        int randomCoord = random.nextInt(getHeight());
        if(randomNumber == 0){
            Apple apple = new Apple(getWidth(), randomCoord);
            listOfDraw.add(apple);
        }
        if(randomNumber == 1){
            Bomb bomb = new Bomb(getWidth(), randomCoord);
            listOfDraw.add(bomb);
        }
        for (int i = 0; i < listOfDraw.size(); i++) {
            listOfDraw.get(i).moveLeft(MenuFrame.speed);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ship.draw(g);
        for (int i = 0; i < listOfDraw.size(); i++) {
            listOfDraw.get(i).draw(g);
        }
    }

    protected void checkIntersections() {
        for (int i = 0; i < listOfDraw.size(); i++) {
            InteractableDrawing drawing = listOfDraw.get(i);
            if (drawing.intersects(ship)) {
                drawing.interact(ship);
                listOfDraw.remove(drawing);
            }
        }
        repaint();
    }

    public void actionPerformed(ActionEvent event){
        
        checkIntersections();
        createDrawing();
        if (ship.getLife() == 0) {
            int choice = JOptionPane.showConfirmDialog(this, "Your life is 0. Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                restartGame();
            } else {
                System.exit(0); // Close the game
            }
        }
    }
    protected void restartGame() {
        ship.life = 3;
        ship.score = 0;
        listOfDraw.clear();
        timer.restart();
        repaint();
    }
}
