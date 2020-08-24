
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sajad
 */
public class seat extends JFrame implements Serializable {
    
    private JToggleButton[] seats = new JToggleButton[50];
    JButton b=new JButton("select");

    seat(int [] arr,int i) {
        setLayout(new BorderLayout());
        setSize(400,300);
        
        
        
        JPanel centerStall = new JPanel(new GridLayout(10,5));
        
centerStall.setBorder(new TitledBorder("Available Seats"));
        
        add(centerStall, BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
        

        ActionListener a = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showSelectedSeats(arr,i);
                if(e.getActionCommand().equals("select")){
                    dispose();
                }
            }
            
        };
b.addActionListener(a);
        for (int ii=0; ii <seats.length; ii++) {
           
            JToggleButton tb = new JToggleButton("S-" + (ii+1));
            tb.addActionListener(a);
            seats[ii] = tb;
centerStall.add(tb);
         if(arr[ii]==1){
             tb.setVisible(false);
         }
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showSelectedSeats(int [] arr,int i) {
        for (int ii=0; ii<seats.length; ii++) {
            JToggleButton tb = seats[ii];
            if (tb.isSelected()) {
                tb.setVisible(false);
                arr[ii]=1;
                Aeroplane.user[0].t.seat_no=(ii+1);
                file_operation f=new file_operation();
ArrayList<bookflight> b=f.readAllData("flight.ser");
                System.out.println(b.get(i).arrival_station);
                

bookflight n=b.get(i);
n.no_of_seats[ii]=1;
f.delete("flight.ser", i);
f.write("flight.ser", n);                
            }
        }
        
    }
    public static void main(String[] args) {
//file_operation f=new file_operation();
//ArrayList<bookflight> b=f.readAllData("flight.ser");
//for(int i=0; i<b.size();i++){
//if(b.get(i).arrival_station.equals("pindi") && b.get(i).departure_station.equals("islamabad")){
//for(int j=0;j<b.get(i).no_of_seats.length;j++){
//    System.out.println(b.get(i).no_of_seats[j]);
//}    
//new seat(b.get(i).no_of_seats,i);
//    System.out.println("i=="+i);
//break;
//}
//}
//        
    }
    }
  

