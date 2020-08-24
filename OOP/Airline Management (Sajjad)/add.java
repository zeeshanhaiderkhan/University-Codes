
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class add extends JFrame{
    Icon logoImage;
    JLabel l;
    JLabel l3=new JLabel("ARRIVAL STATION");
    JTextField f3=new JTextField(20);
    JLabel l4=new JLabel("DEPARTURE STATION");
    JTextField f4=new JTextField(20);
    JLabel l5=new JLabel("DATE");
    JTextField f5=new JTextField(20);
    JLabel l6=new JLabel("DEPARTURE TIME");
    JTextField f6=new JTextField(20);
    JLabel l7=new JLabel("ARRIVAL TIME");
    JTextField f7=new JTextField(20);
    JLabel l8=new JLabel("PRICE");
    JTextField f8=new JTextField(20);
    JButton b1=new JButton("ADD");
    JButton b2=new JButton("BACK");
    JPanel p1=new JPanel(new GridLayout(8,2));
    public add() {
         setLayout(null);
         setSize(1280,720);
       
        
        //super("ADD FLIGHT");
         logoImage= new ImageIcon("C:\\Users\\sajad\\Downloads\\finalproject\\finalproject\\src\\1028.jpg");
         l=new JLabel(logoImage);
       
         l.setIcon(logoImage);
        l.setBounds(0,0,1280,720);
        l3.setFont(new Font("times new roman",Font.BOLD,18));
        l4.setFont(new Font("times new roman",Font.BOLD,18));
        l5.setFont(new Font("times new roman",Font.BOLD,18));
        l6.setFont(new Font("times new roman",Font.BOLD,18));
        l7.setFont(new Font("times new roman",Font.BOLD,18));
        l8.setFont(new Font("times new roman",Font.BOLD,18));
        b1.setFont(new Font("times new roman",Font.BOLD,18));
        b2.setFont(new Font("times new roman",Font.BOLD,18));
        f3.setFont(new Font("times new roman",Font.BOLD,20));
        f4.setFont(new Font("times new roman",Font.BOLD,20));
        f5.setFont(new Font("times new roman",Font.BOLD,20));
        f6.setFont(new Font("times new roman",Font.BOLD,20));
        f7.setFont(new Font("times new roman",Font.BOLD,20));
        f8.setFont(new Font("times new roman",Font.BOLD,20));
        
     f3.setOpaque(false);
     f4.setOpaque(false);
     f5.setOpaque(false);
     f6.setOpaque(false);
     f7.setOpaque(false);
     f8.setOpaque(false);
    Color color=new Color(176, 94, 79);
        b1.setBackground(color);
        b2.setBackground(color);
     
        p1.add(l3);
        p1.add(f3);
        p1.add(l4);
        p1.add(f4);
        p1.add(l5);
        p1.add(f5);
        p1.add(l6);
        p1.add(f6);
        p1.add(l7);
        p1.add(f7);
        p1.add(l8);
        p1.add(f8);
        p1.add(b1);
        p1.add(b2);
    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       p1.setBounds(0, 0 ,1280, 720);
      p1.setOpaque(false);
        action a=new action();
        b1.addActionListener(a);
        b2.addActionListener(a);
     add(p1);
        
           getContentPane().add(l);
        setVisible(true);
        }
    
    class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("BACK")){
                new admin_page();
                        
            }
            else {
              String arrival_station=f3.getText();
              String departure_station=f4.getText();
              String d=f5.getText();
              String[] date=d.split("/");
              date da=new date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
              String time=f6.getText();
              String[] t=time.split(":");
              time arrival_time=new time(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
              time=f7.getText();
              t=time.split(":");
              time depart_time=new time(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
              int price=Integer.parseInt(f8.getText());
              file_operation f=new file_operation();
              int[] arr=new int[50];
              f.write("flight.ser", new bookflight(arr,"bussiness",arrival_station,departure_station,da,arrival_time,depart_time,price));
              
            JOptionPane.showMessageDialog(null, "new flight added successfully");
           
        
        }
        
    }
    
    }
    public static void main(String[] args) {
        new add();
    }
}
    

