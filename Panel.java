import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    JLabel label1;
    JTextField textField1;
    public Panel(String label){
        setLayout(new GridLayout(1,2));
        label1 = new JLabel(label);
        add(label1);
        textField1 = new JTextField();
        textField1.setEditable(true);
        add(textField1);
    }
}