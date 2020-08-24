
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class buy_ticket extends JFrame{
    ImageIcon i=new ImageIcon("C:\\Users\\sajad\\Downloads\\finalproject\\finalproject\\src\\10288.jpg");
    JLabel pic=new JLabel(i);
    JLabel l0=new JLabel("                                         BUY      A");
    JLabel l00=new JLabel("TICKET ");
    
    JLabel l1=new JLabel("DATE ");
   JLabel l2=new JLabel(" ARRIVAL STATION ");
    JLabel l3=new JLabel("DEPARTURE STATION");
     JLabel l4=new JLabel( "PRICE ");
   JLabel l5=new JLabel(" SEAT ");
    JLabel l6=new JLabel("DEPARTURE TIME");
    
    JTextField f1=new JTextField(20);
    JTextField f2=new JTextField(20);
    JTextField f3=new JTextField(20);
    JTextField f4=new JTextField(20);
    JTextField f5=new JTextField(20);
    JTextField f6=new JTextField(20);
    JButton b1=new JButton("DONE");
    JButton b2=new JButton("HOME");
    JButton b3=new JButton("SELECT SEAT");
    JPanel p1=new JPanel(new GridLayout(8,2));
    
  buy_ticket(String a,String b,String c,String d,String e) {
        super("TICKET");
        setSize(1280,720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        l0.setFont(new Font("times new roman",Font.BOLD,30));
        l00.setFont(new Font("times new roman",Font.BOLD,28));
        l1.setFont(new Font("times new roman",Font.BOLD,18));
        l2.setFont(new Font("times new roman",Font.BOLD,18));
        l3.setFont(new Font("times new roman",Font.BOLD,18));
        l4.setFont(new Font("times new roman",Font.BOLD,18));
         l5.setFont(new Font("times new roman",Font.BOLD,18));
        l6.setFont(new Font("times new roman",Font.BOLD,18));
        f1.setFont(new Font("times new roman",Font.BOLD,18));
        f2.setFont(new Font("times new roman",Font.BOLD,18));
        f3.setFont(new Font("times new roman",Font.BOLD,18));
        f4.setFont(new Font("times new roman",Font.BOLD,18));
        f5.setFont(new Font("times new roman",Font.BOLD,18));
        l6.setFont(new Font("times new roman",Font.BOLD,18));
        b1.setFont(new Font("times new roman",Font.BOLD,18));
        b2.setFont(new Font("times new roman",Font.BOLD,18));
        b3.setFont(new Font("times new roman",Font.BOLD,18));
        //add(pic);
        p1.add(l0);
        p1.add(l00);
        p1.add(l1);
        f1.setBackground(Color.yellow);
        f1.setOpaque(false);
        f1.setText(e);
        p1.add(f1);
        p1.add(l2);
        f2.setBackground(Color.yellow);
        f2.setOpaque(false);
        f2.setText(a);
        p1.add(f2);
        p1.add(l3);
        f3.setBackground(Color.yellow);
        f3.setOpaque(false);
        f3.setText(b);
        p1.add(f3);
        p1.add(l4);
        f4.setBackground(Color.yellow);
        f4.setOpaque(false);
        f4.setText(d);
        p1.add(f4);
        p1.add(l5);
        f5.setBackground(Color.yellow);
        f5.setOpaque(false);
        p1.add(b3);
        p1.add(l6);
        f6.setBackground(Color.yellow);
        f6.setOpaque(false);
        f6.setText(c);
        p1.add(f6);
        
        b1.setBackground(Color.yellow);
        b1.setOpaque(false);
        p1.add(b1);
        b2.setBackground(Color.yellow);
        b2.setOpaque(false);
        b3.setBackground(Color.yellow);
        b3.setOpaque(false);
        p1.add(b2);
        p1.setBounds(150, 0, 950, 600);
        pic.setBounds(0,0,1280,720);
        add(p1);
       getContentPane().add(pic);
       p1.setOpaque(false);
                action aa=new action();
              
              b3.addActionListener(aa);
              b1.addActionListener(aa);
              b2.addActionListener(aa);
        
        
  }
   class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("SELECT SEAT")){
                file_operation f=new file_operation();
ArrayList<bookflight> b=f.readAllData("flight.ser");
for(int i=0; i<b.size();i++){
if(b.get(i).arrival_station.equals(f2.getText()) && b.get(i).departure_station.equals(f3.getText())){ 
new seat(b.get(i).no_of_seats,i);
break;
}
}
            }
        
            else if(ae.getActionCommand().equals("DONE")){
                System.out.println("i am done");
                String d=f1.getText();
              String[] date=d.split("/");
              date da=new date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
              String time=f6.getText();
              String[] t=time.split(":");
              time dept_time=new time(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
             Aeroplane.user[0].t.setDeparture_time(dept_time);
             Aeroplane.user[0].t.setDate_flight(da);
             Aeroplane.user[0].t.setPrice(Integer.parseInt(f4.getText()));
             Aeroplane.user[0].t.setArrival_station(f2.getText());
             Aeroplane.user[0].t.setDeparture_station(f3.getText());
                System.out.println(Aeroplane.user[0].t.date_flight.date());
                file_operation f=new file_operation();
                ArrayList<passenger> p=f.readAllData("passenger.ser");
                passenger chng=Aeroplane.user[0];
                for(int i=0;i<p.size();i++){
                    if(p.get(i).id==Aeroplane.user[0].id){
                        f.delete("passenger.ser", i);
                        f.write("passenger.ser", chng);
                        break;
                    }
                }
                new user_panel();
                dispose();
            }
            else{
                new user_panel();
            }
        
        
        
        
        
        
        }}
    
   
    
}
