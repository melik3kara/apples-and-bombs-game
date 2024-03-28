import java.awt.Graphics;

public interface InteractableDrawing {
    int SPEED =  MenuFrame.speed;;
    boolean intersects(Ship s);
    void interact(Ship s);
    boolean moveLeft(int speed);
    void draw(Graphics g);
    
    public int getX();
    public void setX(int x);
    public int getY();
    public void setY(int y);
    public int getSIZE();
}
