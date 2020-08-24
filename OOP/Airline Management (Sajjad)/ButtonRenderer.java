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
import javax.swing.*;
import javax.swing.table.*;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
  
  public ButtonRenderer() {
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
      new buy_ticket(a,d,tt,p,da);
      
    }
    setText("BOOK");
    return this;
  }
}