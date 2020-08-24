import javax.swing.*;
import java.awt.*;
import java.util.*;
public class MyApp extends JFrame{
    public MyApp(){
        super();
        //setSize(new Dimension(600,600));
        setLayout(new BorderLayout());
        
        Task task = new Task();
        DrawPanel clock = new DrawPanel();
        clock.setPreferredSize(new Dimension(600,600));
        
        getContentPane().add(clock, BorderLayout.CENTER);
        Time t= new Time(clock);
        task.bind(t);
        java.util.Timer timer = new java.util.Timer(true);
        
        timer.schedule(task,0,1000);
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}