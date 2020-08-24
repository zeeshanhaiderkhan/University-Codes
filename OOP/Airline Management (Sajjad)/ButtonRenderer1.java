/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sajad
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonRenderer1 extends JButton implements TableCellRenderer {
  
  public ButtonRenderer1() {
    setOpaque(true);
  }
   
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
    String a=(String) table.getModel().getValueAt(row,1);
         String d=(String) table.getModel().getValueAt(row,2);
        String tt=(String) table.getModel().getValueAt(row,3);
        int pa=(int) table.getModel().getValueAt(row,7);
        String p=""+pa;
        String da=(String) table.getModel().getValueAt(row,0);
        file_operation f=new file_operation();
        ArrayList<bookflight> b=f.readAllData("flight.ser");
        for(int i=0;i<b.size();i++){
            if(b.get(i).arrival_station.equals(a) && b.get(i).departure_station.equals(d)&& b.get(i).takeoff_time.time().equals(tt)){
                f.delete("flight.ser", i);
                break;
            }
        }
        ArrayList<passenger> pass=f.readAllData("passenger.ser");
         for(int i=0;i<pass.size();i++){
            if(pass.get(i).t.arrival_station.equals(a) && pass.get(i).t.departure_station.equals(d)&& pass.get(i).t.departure_time.equals(tt)){
                pass.get(i).t=null;
            
            }
        }
        new admin_page();
       
    }
    setText("Delete");
    return this;
  }
}