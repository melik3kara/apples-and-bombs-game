import java.awt.*;
public class Bomb implements InteractableDrawing{

    Rectangle rectBomb;
    private int x; 
    private int y; 
    static final int SIZE = 20; 

    public Bomb(int x, int y){
        rectBomb = new Rectangle(SIZE, SIZE);
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean intersects(Ship s) {
        if((x+SIZE> s.getX() && s.getX()+ s.getWidth()> x)&&
        (s.getY()+ s.getHeight()> y && y+SIZE> s.getY())){
            return true;
        }
        return false;
    }

    @Override
    public void interact(Ship s) {
        s.decreaseLife();
    }

    @Override
    public boolean moveLeft(int speed) {
        this.x -= speed;
        return x + SIZE < 0;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, SIZE, SIZE);
        g.setColor(Color.RED);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getSPEED() {
        return SPEED;
    }
}