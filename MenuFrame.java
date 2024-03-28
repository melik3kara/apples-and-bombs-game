import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuFrame extends JFrame{

    static String name;
    static int speed;
    Panel panel1;
    Panel panel2;
    JButton button;
    ButtonListener list1;
    
    public MenuFrame(){
        setLayout(new GridLayout(3,1));
        setPreferredSize(new Dimension(600, 600));
        panel1 = new Panel("Name:");
        add(panel1);
        panel2 = new Panel("Speed:");
        add(panel2);
        button = new JButton("Start");
        list1 = new ButtonListener();
        button.addActionListener(list1);
        add(button);
        pack();
        setVisible(true);
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            name = panel1.textField1.getText();
            String speedInput = panel2.textField1.getText();
            if(name.equals("")){
                JOptionPane.showMessageDialog(MenuFrame.this, "Name cannot be empty!");
                setVisible(true);
            }
            else if (!isNumeric(speedInput)) {
                JOptionPane.showMessageDialog(MenuFrame.this, "Speed should contain only numbers!");
                setVisible(true);
            }
            else {
            speed = Integer.parseInt(speedInput);
            GameFrame gFrame = new GameFrame();
            gFrame.gPanel.createDrawing();
            }
        }
        
        private boolean isNumeric(String str) {
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    restartFrame();
                    return false;
                }
            }
            return true;
        }
        protected void restartFrame() {
            repaint();
        }
    }
}