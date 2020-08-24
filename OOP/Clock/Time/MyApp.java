import javax.swing.*;
import java.awt.*;

public class MyApp extends JFrame{
    public MyApp(){
        super();
        setSize(new Dimension(600,600));
        add(new DrawPanel());
        setVisible(true);
    }
}