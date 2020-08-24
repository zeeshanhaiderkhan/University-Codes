/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author fa18-bcs-067
 */
public class Aeroplane extends JFrame{
    
    Icon logoImage;
    Icon logoImage1;
    JLabel l;
    JLabel login;
    JTextField t;
 static passenger [] user=new passenger[1];
    JRadioButton r1=new JRadioButton("ADMIN");
    JRadioButton r2=new JRadioButton("PASSENGER");
    JPasswordField pass=new JPasswordField();
ButtonGroup c=new ButtonGroup();

   // JProgressBar jb=new JProgressBar(0,100);
    JButton b=new JButton("LOGIN");
    JButton b1=new JButton("SIGNUP");
    JPanel p=new JPanel(new GridLayout(2,1));
JLabel title=new JLabel("LETS FLY....");
    public Aeroplane(){
        logoImage = new ImageIcon("C:\\Users\\sajad\\Downloads\\finalproject\\finalproject\\src\\1028.jpg");
        logoImage1=new ImageIcon("C:\\Users\\sajad\\Downloads\\finalproject\\finalproject\\src\\log.jpg");
        t=new JTextField(10);
        l=new JLabel(logoImage);
        login=new JLabel(logoImage1);
        
        setLayout(null);
b.setOpaque(false);
b1.setOpaque(false);
Color color1=new Color(161, 5, 89);
        b.setForeground(color1);
        b1.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
        b1.setForeground(color1);
title.setFont(new Font("TimesNewRoman", Font.BOLD, 80));
title.setForeground(color1);

        c.add(r1);
        c.add(r2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        l.setIcon(logoImage);
        l.setBounds(0,0,1280,720);
        title.setBounds(40,10,500,200);
        r1.setOpaque(false);
        Color c2=new Color(247, 200, 183);
        t.setBackground(c2);
        pass.setBackground(c2);
        t.setText(" NAME");
        pass.setText("PASSWORD");
        
       r2.setOpaque(false);
       b.setBorderPainted(false);
       b1.setBorderPainted(false);
      //  jb.setBounds(0,600,1280,15);
add(title);

      //  jb.setValue(0);
        p.add(b);
        p.setBounds(1000,490,150,100);
        t.setBounds(960,360,220,40);
        r1.setBounds(950,270,100,20);
     p.setOpaque(false);
        r2.setBounds(1055,270,150,20);
      //t.setOpaque(false);
        t.setBorder(null);
        t.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        t.setForeground(new Color(250, 147, 110));
        pass.setBounds(960,415,220,40);
 r1.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
  r2.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
     // pass.setOpaque(false);
        pass.setBorder(null);
        pass.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        pass.setForeground(new Color(250, 147, 110));
        b.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
       // b.setForeground(Color.ORANGE);
       // b1.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
       // b1.setForeground(Color.ORANGE);

        p.add(b1);
        Color color=new Color(13, 109, 228);
        b.setBackground(color);
        b1.setBackground(color);
        p.setOpaque(false);
        login.setBounds(900,0,400,0);
        //jb.setStringPainted(true);
        //jb.setBackground(color);
        //jb.setForeground(color);
        //add(jb);
        
        
        add(r1);
        add(r2);
        add(p);
        add(pass);
        add(t);
        add(login);
b1.setVisible(false);



mouse m=new mouse();
pass.addMouseListener(m);
t.addMouseListener(m);
        
  action a=new action();
        b.addActionListener(a);
        b1.addActionListener(a);  
r1.addActionListener(a);
r2.addActionListener(a);

        getContentPane().add(l);
        setVisible(true);
    }
    public class action implements ActionListener{


        public void actionPerformed(ActionEvent ae) {

            
         if(r1.isSelected() && ae.getActionCommand().equals("LOGIN")&&t.getText().equals("admin") && pass.getText().equals("1")){
             new admin_page();
             dispose();
            JOptionPane.showMessageDialog(null,"admin");
            }
            else if(r2.isSelected() && ae.getActionCommand().equals("LOGIN")){
                file_operation ch=new file_operation();
                ArrayList<passenger> p=(ArrayList<passenger> )ch.readAllData("passenger.ser");
                        
                for(int i=0;i<p.size();i++){
                    if((p.get(i).getFirstname().equals(t.getText()) && (p.get(i).getPassword()).equals(pass.getText()))){
                        user[0]=p.get(i);
                        new user_panel();
                        dispose();
                    }
                }
                JOptionPane.showMessageDialog(null,"PASSENGER");
               
            }
            else if( ae.getActionCommand().equals("SIGNUP")){
                
                
                JOptionPane.showMessageDialog(null,"signup");
                new user();
                dispose();
            }
            
            else if(ae.getActionCommand().equals("SIGNUP") || ae.getActionCommand().equals("LOGIN") ){
                JOptionPane.showMessageDialog(null,"choose option");
            }
        else if(r1.isSelected()){
b1.setVisible(false);
            }
       else if(r2.isSelected()){
            b1.setVisible(true);
            }
         
           
        }
        
        
        

    }
    public class mouse  implements MouseListener{  
 

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getClickCount()==2){
             t.setText("");
             pass.setText("");}
        }

        @Override
        public void mousePressed(MouseEvent me) {
           //t.setText("");
        }

        @Override
        public void mouseReleased(MouseEvent me) {
           //t.setText("");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            
        
          
        }

        @Override
        public void mouseExited(MouseEvent me) {
             //t.setText("");
        }

}
    public static void main(String[] args) {
        new Aeroplane();

    }
}
