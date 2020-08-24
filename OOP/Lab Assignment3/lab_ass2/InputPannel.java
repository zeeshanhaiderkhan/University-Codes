import java.awt.*;
import javax.swing.*;
import java.util.Locale;
public class InputPannel extends JPanel
{
    private JScrollPane t;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    public InputPannel(){
        super();
        setLayout(new GridLayout(11,14,30,7));
        add(new JLabel("Customer Code "));
        t1 = new JTextField();
        add(t1);
        add(new JLabel("Name "));
        t2 = new JTextField();
        add(t2);
        add(new JLabel("Address "));
        t = new JScrollPane(new JTextArea());
        t.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(t);
        add(new JLabel("City "));
        t3 = new JTextField();
        add(t3);
        add(new JLabel("State "));
        t4 = new JTextField();
        add(t4);
        add(new JLabel("Postcode "));
        t5 = new JTextField();
        add(t5);
        add(new JLabel("Country "));
        add(new JComboBox(getCountries()));
        add(new JLabel("Contact "));
        t6 = new JTextField();
        add(t6);
        add(new JLabel("Phone "));
        t7 = new JTextField();
        add(t7);
        add(new JLabel("Fax "));
        t8 = new JTextField();
        add(t8);
        add(new JLabel("Email "));
        t9 = new JTextField();
        add(t9);
        setSize(350,450);
    }
    public String[] getCountries() {
        String[] countryCode = Locale.getISOCountries();
        String[] countryList = new String[countryCode.length];
        for (int i = 0; i < countryList.length; i++) {
            Locale locale = new Locale("", countryCode[i]);
            countryList[i] = locale.getDisplayCountry();
        }
        return countryList;
    }
}