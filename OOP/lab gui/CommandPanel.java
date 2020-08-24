import java.awt.*;
import javax.swing.*;


public class CommandPanel extends JPanel
{
    

    private JButton ok;
     JButton close;
   
    public CommandPanel()
    {
       super();
       
       setLayout(new GridLayout(1,2,20,20));
       
       ok = new JButton("OK");
       add(ok);
       
       close = new JButton("Close");
       add(close);
       
      
       
    }

    
}
