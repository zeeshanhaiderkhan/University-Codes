
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class my_flight extends JFrame implements Serializable{
     JTable table;
     JScrollPane scrollPane ;
    JLabel l=new JLabel("BOOKED FILES");
 
    JButton b1=new JButton("BACK");
 
    public my_flight() {
        String [] d={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[]  m={"1","2","3","4","5","6","7","8","9","10","11","12"};
        String [] y={"2019","2020","2021","2022"};
        String [] t={"islamabad","pindi","karachi"};
        String [] f={"islamabad","pindi","karachi"};
        String [] c={"bussiness","economy"};
        setLayout(null);
        setSize(1280,720);
        
        String[] columnNames = {"NAME","AGE","PASSPORT_NO","DATE","Arrival Station","Departure Station","Take-off time","SEAT_NO","Price"};
        file_operation file=new file_operation();
        ArrayList<passenger> arr = file.readAllData("passenger.ser");
        Object[][] data = new Object[arr.size()][9];
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).id==Aeroplane.user[0].id){
                System.out.println(arr.get(i).id);
                
            data[i][0] = arr.get(i).firstname;
            data[i][1] = arr.get(i).age;
            data[i][2] = arr.get(i).passport_no;
            data[i][3] = arr.get(i).t.date_flight.date();
            data[i][4] = arr.get(i).t.arrival_station;
            data[i][5] = arr.get(i).t.departure_station;
            data[i][6] = arr.get(i).t.departure_time.time();
            data[i][7] = arr.get(i).t.seat_no;
            data[i][8] =arr.get(i).t.price;}
        }
       table = new JTable(data, columnNames);
         scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //table.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
//table.setVisible(false);

     //   add(table.getTableHeader(), BorderLayout.PAGE_START);
        JPanel p1=new JPanel(new FlowLayout());
       // JTableHeader h=table.getTableHeader();
        
      //  JPanel p2=new JPanel(new BorderLayout());
       // h.setBounds(0,0,900,400);
      //  h.setPreferredSize(new Dimension(1280,50));
       //p2.add(scrollPane);
      
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       // table.setVisible(false);
      // add(p1,BorderLayout.SOUTH);
     
      //  add(table,BorderLayout.CENTER);
        
  
        TableColumn column = null;
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(110);
        table.getColumnModel().getColumn(2).setPreferredWidth(110);
        table.getColumnModel().getColumn(3).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(6).setPreferredWidth(110);
        table.getColumnModel().getColumn(7).setPreferredWidth(110);
        table.getColumnModel().getColumn(8).setPreferredWidth(110);
        
       p1.add(l);
       l.setFont(new Font("times new roman",Font.BOLD,28));
       p1.setBounds(0, 0, 1280, 50);
       
     //  p2.setBounds(0, 50, 1280, 50);
       scrollPane.setBounds(0, 50, 1280, 620);
        add(p1);
      // add(p2);
    add(scrollPane);
   action a=new action();
   b1.addActionListener(a);
   
  
        setVisible(true);
    }

    
    class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
   
   new user_panel();
   dispose();
        }
            }

    public static void main(String[] args) {
        new my_flight();
    }


}
        
        
    
