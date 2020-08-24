import java.awt.*;
import javax.swing.*;
public class CommandPannel extends JPanel{
    public JButton btn1;
    public JButton btn2;
    public CommandPannel(){
        super();
        setLayout(new FlowLayout());
        btn1 = new JButton("OK");
        btn1.setSize(100,100);
        add(btn1);
        btn2 = new JButton("Cancel");
        btn2.setSize(100,100);
        add(btn2);
    }
}