import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel{
    private JTextField a,b,r;
    public InputPanel(){
        super();
        setLayout(new GridLayout(3,2,50,50));
        add(new JLabel("n1"));
        a=new JTextField();
        add(a);
        
        add(new JLabel("n2"));
        b= new JTextField();
        add(b);
        
        add(new JLabel("result"));
        r= new JTextField();
        add(r);
        
        r.setEnabled(false);
    }
    public void sum(){
        int a   = Integer.parseInt(this.a.getText());
        int b = Integer.parseInt(this.b.getText());
        r.setText(Integer.toString(a+b));
        
    }
    public void sub(){
        int a   = Integer.parseInt(this.a.getText());
        int b = Integer.parseInt(this.b.getText());
        r.setText(Integer.toString(a-b));
        
    }
    public void mul(){
        int a   = Integer.parseInt(this.a.getText());
        int b = Integer.parseInt(this.b.getText());
        r.setText(Integer.toString(a*b));
        
    }
    public void div(){
        int a   = Integer.parseInt(this.a.getText());
        int b = Integer.parseInt(this.b.getText());
        r.setText(Integer.toString(a/b));
        
    }
}