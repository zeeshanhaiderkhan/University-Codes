import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainPanel extends JFrame{
    private InputPanel ip;
    private CommandPanel cp;
    private BtnHandler btn;
    public MainPanel(){
        super("My First Calculator");
        setLayout(new BorderLayout());
        
        ip = new InputPanel();
        cp = new CommandPanel();
        btn = new BtnHandler();
        add(ip,BorderLayout.CENTER);
        add(cp,BorderLayout.SOUTH);
        pack();
        cp.plus.addActionListener(btn);
        cp.minus.addActionListener(btn);
        cp.multiply.addActionListener(btn);
        cp.divide.addActionListener(btn);
    }
    public static void main(){
        MainPanel calculator = new MainPanel();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
    private class BtnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            if(cmd.equals("+")){
                ip.sum();
            }
            else if(cmd.equals("-")){
            ip.sub();
            }
            else if(cmd.equals("X")){
                ip.mul();
            }
            else if(cmd.equals("/")){
                ip.div();
            }
            
        }
    }
}