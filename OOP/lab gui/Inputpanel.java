
import java.awt.*;
import javax.swing.*;

public class Inputpanel extends JPanel
{

    private JTextField custCode,name,city,state,postcode,contact,phone,fax,email;
    private JTextPane address;
    String[] countryStrings = { "Pakistan", "England", "France", "Germany", "China" };

    JComboBox country;

    public Inputpanel()
    {
       super();
       setLayout(new GridLayout(12,1,20,5));
       
       //BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
       
       //this.setLayout(boxlayout);
       
       add(new JLabel("Customer Code",SwingConstants.RIGHT));
       custCode = new JTextField();
       add(custCode);
       
       add(new JLabel("Name",SwingConstants.RIGHT));
       name = new JTextField();
       add(name);
       
       add(new JLabel("Address",SwingConstants.RIGHT));
       address = new JTextPane();
       JScrollPane sp = new JScrollPane(address);
       sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       add(sp);
       
       add(new JLabel("City",SwingConstants.RIGHT));
       city = new JTextField();
       add(city);
       
       add(new JLabel("State",SwingConstants.RIGHT));
       state = new JTextField();
       add(state);
       
       add(new JLabel("Postcode",SwingConstants.RIGHT));
       postcode = new JTextField();
       add(postcode);
       
       add(new JLabel("Country",SwingConstants.RIGHT));  //
       country = new JComboBox(countryStrings);
       country.setSelectedIndex(0);
       //country.addActionListener(this);
       add(country);
       
       add(new JLabel("Contact",SwingConstants.RIGHT));
       contact = new JTextField();
       add(contact);
       
       add(new JLabel("Phone",SwingConstants.RIGHT));
       phone = new JTextField();
       add(phone);
       
       add(new JLabel("Fax",SwingConstants.RIGHT));
       fax = new JTextField();
       add(fax);
       
       add(new JLabel("Email",SwingConstants.RIGHT));
       email = new JTextField();
       add(email);
       
       
      // add(panel, BorderLayout.CENTER);
    }
    
    public JPanel getInputPanel(){
        return this;
    }

 
 }
