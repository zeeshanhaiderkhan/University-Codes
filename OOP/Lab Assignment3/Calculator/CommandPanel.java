import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel{
    public JButton plus,minus,multiply,divide;
    
    public CommandPanel(){
        super();
        setLayout(new FlowLayout());
        plus = new JButton("+");
        add(plus);
        minus = new JButton("-");
        add(minus);
        multiply = new JButton("X");
        add(multiply);
        divide= new JButton("/");
        add(divide);
        plus.setSize(50,50);
        minus.setSize(50,50);
        multiply.setSize(50,50);
        divide.setSize(50,50);
        
        
    }
    
}