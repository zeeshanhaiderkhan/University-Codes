
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class view extends JFrame implements Serializable{
     JTable table;
     JScrollPane scrollPane ;
    JLabel l=new JLabel("FROM   ");
    JLabel l1=new JLabel("    TO  ");
    JLabel l2=new JLabel("  DATE  ");
    JLabel l3=new JLabel("  CATAGORIES  ");
    JButton b1=new JButton("SEARCH");
    JButton b2=new JButton("VIEW ALL");
    JComboBox To;
    JComboBox From;
     JComboBox day;
    JComboBox month;
     JComboBox year;
    JComboBox catogries;

    public view(ArrayList<bookflight> arr,boolean s) {
        String [] d={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[]  m={"1","2","3","4","5","6","7","8","9","10","11","12"};
        String [] y={"2019","2020","2021","2022"};
        String [] t={"islamabad","pindi","karachi"};
        String [] f={"islamabad","pindi","karachi"};
        String [] c={"bussiness","economy"};
        To=new JComboBox(t);
        
        From=new JComboBox(f);
        day=new JComboBox(d);
        month=new JComboBox(m);
        year=new JComboBox(y);
        catogries=new JComboBox(c);
        setLayout(null);
        setSize(1280,720);
        
        String[] columnNames = {"DATE","Arrival Station","Departure Station","Take-off time","Arrival Time","Catagories","No of seats","Price"," "};
//        file_operation file=new file_operation();
//        ArrayList<bookflight> arr = file.readAllData("flight.ser");
        Object[][] data = new Object[arr.size()][9];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i).getDate().date();
            data[i][1] = arr.get(i).getArrival_station();
            data[i][2] = arr.get(i).getDeparture_station();
            data[i][3] = arr.get(i).getTakeoff_time().time();
            data[i][4] = arr.get(i).getArrival_time().time();
            data[i][5] = arr.get(i).getCategory();
            data[i][6] = arr.get(i).getNo_of_seats().length;
            data[i][7] = arr.get(i).getPrice();
          //  data[i][8]=bb;
        }
       table = new JTable(data, columnNames);
         scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.getColumn(" ").setCellRenderer(new ButtonRenderer());
        //table.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
//table.setVisible(false);

     //   add(table.getTableHeader(), BorderLayout.PAGE_START);
        JPanel p1=new JPanel(new FlowLayout());
       // JTableHeader h=table.getTableHeader();
        
      //  JPanel p2=new JPanel(new BorderLayout());
       // h.setBounds(0,0,900,400);
      //  h.setPreferredSize(new Dimension(1280,50));
       //p2.add(scrollPane);
        p1.add(l);
        p1.add(From);
        p1.add(l1);
        p1.add(To);
        p1.add(l3);
        p1.add(catogries);
        p1.add(l2);
        p1.add(day);
        p1.add(month);
        p1.add(year);
        p1.add(b1);
        p1.add(b2);
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
        
        
       p1.setBounds(0, 0, 1280, 50);
       
     //  p2.setBounds(0, 50, 1280, 50);
       scrollPane.setBounds(0, 50, 1280, 620);
        add(p1);
      // add(p2);
    add(scrollPane);
   table.setVisible(s);
   action a=new action();
   b1.addActionListener(a);
   b2.addActionListener(a);
  
        setVisible(true);
    }

    
    class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("VIEW ALL")){
                file_operation file=new file_operation();
        ArrayList<bookflight> arr = file.readAllData("flight.ser");
        new view(arr,true);
          dispose();
           
            }
            else if (ae.getActionCommand().equals("SEARCH")){
        file_operation file=new file_operation();
        ArrayList<bookflight> arr = file.readAllData("flight.ser");
        String dep=(String) From.getSelectedItem();
        String arriv=(String) To.getSelectedItem();
        String cat=(String) catogries.getSelectedItem();
        int d=Integer.parseInt((String) day.getSelectedItem());
        int m=Integer.parseInt((String) month.getSelectedItem());
        int y=Integer.parseInt((String) year.getSelectedItem());
        
                System.out.println(arr.size());
                int i=0;
        while(i<arr.size()){
             if(arr.get(i).departure_station.equals(dep) &&arr.get(i).arrival_station.equals(arriv) && arr.get(i).category.equals(cat) &&arr.get(i).date.date==d && arr.get(i).date.month==m && arr.get(i).date.year==y ){
                 i++;
             }
             else{
                 arr.remove(i);
                 i=0;
             }
                
            }
        new view(arr,true);
        dispose();
            }}
        
        
    }
    public static void main(String[] args) {
//        file_operation f=new file_operation();
//        ArrayList<bookflight> b=f.readAllData("flight.ser");
//        new view(b,false);
    }
    
}
