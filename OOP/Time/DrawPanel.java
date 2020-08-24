import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawPanel extends JPanel{
    double theta = Math.PI;   //initial condition
    BufferedImage img;
    public void paintComponent(Graphics g) {    //draws oval and draws line
        Graphics2D g2d =(Graphics2D) g;
       
        int mx = getWidth()/2;
        int my = getHeight()/2;
        int  r= getWidth()/2;
        try{
            img = ImageIO.read(new File("clock.png"));
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    
        
        
        double secX2  =mx+r*Math.sin(-1*theta); //seconds
        double secY2 = my+r*Math.cos(-1*theta);
        
        double minX2 = mx+r*Math.sin(-1*theta/1800);//minutes
        double minY2 = mx+r*Math.cos(-1*theta/1800);
        
        double hrsX2 = mx+r*Math.sin(-1*theta/(3600*12));//hours
        double hrsY2 = mx+r*Math.cos(-1*theta/(3600*12));
        
        g2d.drawImage(img,0,0,600,600,null);
        g2d.setColor(Color.WHITE);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(mx,my,(int)secX2,(int)secY2);  //seconds hand
        g2d.setStroke(new BasicStroke(10));
        g2d.drawLine(mx,my,(int)minX2-20,(int)minY2-20);    //minutes hand
        g2d.setStroke(new BasicStroke(15));
        g2d.drawLine(mx,my,(int)hrsX2-100,(int)hrsY2-100);  //hours hand*/
        
    }
    public void incrTheta(double increment){   //default pi/30 for 6 degrees
        theta+=increment;
    }
   
}