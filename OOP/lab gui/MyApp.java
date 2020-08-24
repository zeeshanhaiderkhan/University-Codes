import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyApp extends JFrame
{

    private Inputpanel input;
    private CommandPanel command;

   private JButton ok;
     JButton close;
    public MyApp()
    {
        super("Customer Dialog");
        setLayout(new GridLayout(2,1));
        setSize(400,800);
        
        input = new Inputpanel();
        input.setSize(300,400);
        input.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.setAlignmentY(Component.CENTER_ALIGNMENT);
        input.setBorder(BorderFactory.createLineBorder(Color.black));
       // command = new CommandPanel();
   
        add(input);
       
       
       ok = new JButton("OK");
       add(ok, BorderLayout.SOUTH);
       
       close = new JButton("Close");
       add(close, BorderLayout.SOUTH);
        // add(command,BorderLayout.SOUTH);
        
        //ButtonHandler B = new ButtonHandler();
        
       
        //command.close.addActionListener(B);
    }
    
    public static void main() {
        
        MyApp app = new MyApp();
        
               
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        
    }
    
private class ButtonHandler implements ActionListener {
 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Close")) {
            System.exit(0);
    } 
    else {
        
        //Do Nothing
    }
    
}
}
}





