import java.awt.*;

public class Ship {
    
    Rectangle rectShip;
    final int WIDTH = 40;
    final int HEIGHT = 20;
    int x = (GameFrame.WIDTH - WIDTH) / 2;
    int y = (GameFrame.HEIGHT - HEIGHT) / 2;
    int life;
    int score;
    String name = MenuFrame.name;

    public Ship(){
        rectShip = new Rectangle(x, y, WIDTH, HEIGHT);
        this.life = 3;
        this.score = 0;
    }

    public void draw(Graphics g) {
        // Draw ship
        g.setColor(Color.RED);
        g.fillRect(x, y, WIDTH, HEIGHT);

        // Draw player name on top of the ship
        g.setColor(Color.BLACK);
        g.drawString(name, x + WIDTH / 2 - name.length() * 3, y - 5);

        // Draw life and score
        //g.drawString("Life: " + life, 10, 20);
        //g.drawString("Score: " + score, 10, 40);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public void decreaseLife() {
        life--;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
 
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
