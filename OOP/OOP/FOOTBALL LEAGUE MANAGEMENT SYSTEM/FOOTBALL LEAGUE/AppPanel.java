import javax.swing.*;
import java.awt.*;





public class AppPanel extends JFrame{
        public AppPanel(){
        super("Stadium Registration");
        setSize(600,600);
        add(new StadiumPanel());
        setResizable(false);
        
        ImageIcon panelIcon= new ImageIcon("stadiumIcon.png");
        setIconImage(panelIcon.getImage());
        
        setVisible(true);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        
}