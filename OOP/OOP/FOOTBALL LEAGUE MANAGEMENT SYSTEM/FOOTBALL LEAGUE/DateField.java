import javax.swing.*;
import java.awt.*;
import java.util.*;

//self customised date field
public class DateField extends JPanel{
   private JTextField day,month,year;
   
   public DateField(){
       setLayout(new FlowLayout());
       add(new JLabel("D"));
       day=new JTextField(2);
       add(day);
       add(new JLabel("M"));
       month=new JTextField(2);
       add(month);
       add(new JLabel("Y"));
       year=new JTextField(4);
       add(year);
    }
    public int getDay(){
        return Integer.parseInt(day.getText());
    }
   public int getMonth(){
        return Integer.parseInt(month.getText());
    }
    public int getYear(){
        return Integer.parseInt(year.getText());
    }
    public String getString(){
        return (getDay()+", "+getMonth()+", "+getYear());
    }
    public String getText(){
     return (getDay()+", "+getMonth()+", "+getYear());
    }
    public Date getDate(){
        return new Date(getDay(),getMonth(),getYear());
    }
}