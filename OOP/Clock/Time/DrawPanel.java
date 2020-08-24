package Time;

import javax.swing.*;
import java.awt.*;
import java.util.*;
public class DrawPanel extends JPanel{
    public DrawPanel(){
        
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2d =(Graphics2D) g;
        g2d.drawOval(0,0,getWidth(),getHeight());
        int mx = getWidth()/2;
        int my = getHeight()/2;
        int  r= getWidth()/2;
        double theta = Math.PI/2;
        
        Task task = new Task();
        Time t= new Time();
        task.bind(t);
       java.util.Timer timer = new java.util.Timer(true);
        
        
        for(int i=0;i<1000;i++){
            theta+=(Math.PI)/30;
            int x2  =r*(int)Math.sin(theta);
            int y2 = r*(int)Math.cos(theta);
            g2d.drawLine(mx,my,x2,y2);
            timer.schedule(task,0,1000);
    }
        
    }
}