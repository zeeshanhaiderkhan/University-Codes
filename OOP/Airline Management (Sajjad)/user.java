
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sun.launcher.resources.launcher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class user extends JFrame implements Serializable{
    Icon l;
    JLabel l000=new JLabel("                             USER ");
    JLabel l01=new JLabel("PANAL");
    JLabel l1=new JLabel(" FIRST NAME ");
    JTextField f1=new JTextField(10);
    JLabel l2=new JLabel(" LAST NAME ");
    JTextField f2=new JTextField(10);
    JLabel l3=new JLabel(" AGE ");
    JTextField f3=new JTextField(10);
    JLabel l4=new JLabel(" CONTACT ");
    JTextField f4=new JTextField(10);
    JLabel l5=new JLabel(" CNIC ");
    JTextField f5=new JTextField(10);
    JLabel l6=new JLabel(" EMAIL ");
    JTextField f6=new JTextField(10);
    JLabel l7=new JLabel(" ID ");
    JTextField f7=new JTextField(10);
    JLabel l8=new JLabel(" ADDRESS ");
    JTextField f8=new JTextField(10);
    JLabel l9=new JLabel(" PASSWORD ");
    JTextField f9=new JTextField(10);
    JLabel l0=new   JLabel("     ");
     JLabel l00=new   JLabel("     ");
    JButton b1=new JButton("REGISTER");
    JButton b2=new JButton("LOGIN");
    
    JLabel l11=new JLabel(" PASSPORT NO. ");
    JLabel l22;
    JTextField f11=new JTextField();
    JTextField f22=new JTextField();
    //JButton b3=new JButton("BUY A TICKET");
    JPanel p1=new JPanel(new GridLayout(14,2));
    
    
    public user() {
        super("USER LOGIN");
        l=new ImageIcon("C:\\Users\\DELL\\Desktop\\finalproject\\src\\10288.jpg");
       l22=new JLabel(l);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        l1.setFont(new Font("times new roman",Font.BOLD,18));
        l2.setFont(new Font("times new roman",Font.BOLD,18));
        
        l3.setFont(new Font("times new roman",Font.BOLD,18));
        l4.setFont(new Font("times new roman",Font.BOLD,18));
        l5.setFont(new Font("times new roman",Font.BOLD,18));
        l6.setFont(new Font("times new roman",Font.BOLD,18));
        l7.setFont(new Font("times new roman",Font.BOLD,18));
        l8.setFont(new Font("times new roman",Font.BOLD,18));
                l9.setFont(new Font("times new roman",Font.BOLD,18));
                l11.setFont(new Font("times new roman",Font.BOLD,18));
                l22.setFont(new Font("times new roman",Font.BOLD,18));
                l0.setFont(new Font("times new roman",Font.BOLD,18));
                l01.setFont(new Font("times new roman",Font.BOLD,28));
                l000.setFont(new Font("times new roman",Font.BOLD,28));   
                b1.setFont(new Font("times new roman",Font.BOLD,18));   
                b2.setFont(new Font("times new roman",Font.BOLD,18));   
               // b3.setFont(new Font("times new roman",Font.BOLD,18));   
        p1.add(l000);
        p1.add(l01);
         Color color=new Color(13, 109, 228);
        // b3.setBackground(color);
          b1.setBackground(color);
        b1.setOpaque(false);
       // b3.setOpaque(false);
        //p1.add(l11);
        //p1.add(f11);
        //p1.add(l22);
        //p1.add(f22);
        //p1.add(l00);
        //p1.add(b2);
       p1.add(l22);
        p1.add(l1);
        f1.setOpaque(false);
        //f1.setBackground(color);
        p1.add(f1);
        p1.add(l2);
        f2.setOpaque(false);
        p1.add(f2);
        p1.add(l3);
        f3.setOpaque(false);
        p1.add(f3);
        p1.add(l4);
        f4.setOpaque(false);
        p1.add(f4);
        p1.add(l5);
        f5.setOpaque(false);
        p1.add(f5);
        p1.add(l6);
        f6.setOpaque(false);
        p1.add(f6);
        p1.add(l7);
        f7.setOpaque(false);
        p1.add(f7);
        p1.add(l8);
        f8.setOpaque(false);
        p1.add(f8);
        p1.add(l9);
        f9.setOpaque(false);
        p1.add(f9);
        p1.add(l11);
        f11.setOpaque(false);
        p1.add(f11);
       
      // p1.add(b3);
        p1.add(b1);
        l22.setBounds(0, 0, 1280, 720);
        setLayout(null);
        p1.setBounds(150, 0, 1000, 720);
        p1.setOpaque(false);
        add(p1);
         
        action a=new action();
        b1.addActionListener(a);
        b2.addActionListener(a);
       // b3.addActionListener(a);
      getContentPane().add(l22);
      setVisible(true);
 }
    
    class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("REGISTER")){
                String firstname=f1.getText();
                String lastnamme=f2.getText();
                int age=Integer.parseInt(f3.getText());
                String mobile=f4.getText();
               String CNIC=f5.getText();
               String email=f6.getText();
                int id=Integer.parseInt(f7.getText());
              String address=f8.getText();
              String password=f9.getText();
              String passport_no=f11.getText();
              ticket t=new ticket();
        
                passenger p=new passenger(firstname, lastnamme, age,  CNIC, mobile,email,address, id,password, passport_no,t);
        file_operation write=new file_operation();
     write.write("passenger.ser", p);
     new Aeroplane();
     JOptionPane.showMessageDialog(null,"YOU HAVE REGISTERED SUCCESSFULLY NOW LOG IN TO YOUR ACCOUNT");
     dispose();
                //try {
                    //ArrayList<passenger> tg = (ArrayList<passenger>)write.reading("passenger.ser");
                    
                    
                        //System.out.println(tg.get(0).getAge());
                    
                    //b1.setFont(new Font("times new roman",Font.BOLD,18));
                /*} catch (IOException ex) {
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
            
            
        }
        
    }
        
    public static void main(String[] args) {
        new user();
             
    }
    
}
