import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JFrame
{
    private final JPanel buttonJPanel;
    JButton ok,close;
    
    public ButtonPanel(){
       buttonJPanel= new JPanel();
       buttonJPanel.setLayout(new GridLayout(2,1));
       ok = new JButton("OK");
       buttonJPanel.add(ok);
       
       close = new JButton("Close");
       buttonJPanel.add(close);
       JPanel in = new Inputpanel();
       add(in);
       
       add(buttonJPanel, BorderLayout.SOUTH);
    }
}
