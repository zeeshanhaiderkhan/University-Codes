
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class user_panel  extends JFrame implements Serializable{

    public user_panel() {
        super("USER PANEL");
        ImageIcon i=new ImageIcon("C:\\Users\\DELL\\Desktop\\finalproject\\src\\10288.jpg");
    JLabel pic=new JLabel(i);
    JLabel l0=new JLabel("                     ADMIN PANEL");
     JButton l1=new JButton("VIEW FLIGHTS");
     JButton  l2=new JButton("MY FLIGHTS");
     //JButton l3=new JButton("record");
     JPanel p1=new JPanel(new GridLayout(5,1));
    
        
        
      
        l0.setFont(new Font("times new roman",Font.BOLD,28));
         l1.setFont(new Font("times new roman",Font.BOLD,18));
        l2.setFont(new Font("times new roman",Font.BOLD,18));
        setLayout(null);
        pic.setBounds(0,0,1280,720);
        Color color=new Color(255, 201, 191);
        l0.setBackground(color);
               l1.setBackground(color);
       l2.setBackground(color);
       
       Color c=new Color(176, 94, 79);
      // l0.setForeground(c);
       l1.setForeground(c);
       l2.setForeground(c);
       
      p1.add(l0);
         p1.add(l1);
          p1.add(l2);
       
          add(p1);
          setSize(300, 250);
          action a=new action();
          getContentPane().add(pic);
         
        l1.addActionListener(a);
        l2.addActionListener(a);
               p1.setBounds(400, 20, 1000, 720);
        p1.setSize(500,500);
        p1.setOpaque(false);
          setSize(1280,720);
        setVisible(true);
 }

    
    class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("MY FLIGHTS")){
                if(Aeroplane.user[0].t.seat_no==0){
                   JOptionPane.showMessageDialog(null,"YOU HAVE NOT BOOK ANY FLIGHT");
                }
                else{
               new my_flight();
                dispose();
                }
            }
            else if (ae.getActionCommand().equals("VIEW FLIGHTS")){
                 file_operation f=new file_operation();
                ArrayList<bookflight> arr=f.readAllData("flight.ser");
                new view(arr,false);
                dispose();
            }
            
        }
        
        
        
    }
    public static void main(String[] args) {
        new user_panel();
    }
    }
    

