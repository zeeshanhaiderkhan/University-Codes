import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Test extends JFrame
{
    InputPannel in;
    CommandPannel com;
    BtnHandler b;
    public Test(){
        super("Customer Dialog");
        setLayout(new BorderLayout());
        in = new InputPannel();
        com = new CommandPannel();
        b = new BtnHandler();
        add(in,BorderLayout.CENTER);
        add(com,BorderLayout.SOUTH);
        pack();
        in.setSize(600,1000);
        com.btn2.addActionListener(b);
    }
    public static void main(){
        Test in = new Test();
        in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        in.setVisible(true);
    }
    private class BtnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Cancel")){
                System.exit(0);
            }
        }
   } 
}
