import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.util.Locale;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StadiumPanel extends JPanel implements ActionListener{
 /*t = new JScrollPane(new JTextArea());
        t.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);*/   
    private BufferedImage img;
    private JButton cancelBtn,saveBtn;
    private JTextField name,capacity,street,city,postCode;
    private DateField date;
    private JTextArea description;
    private JComboBox country;
 public StadiumPanel(){
        
   setPreferredSize(new Dimension(600,600));
  
   JPanel namePanel = new JPanel(new GridBagLayout());
   GridBagConstraints constraints = new GridBagConstraints();
   constraints.anchor = GridBagConstraints.WEST;
   constraints.insets = new Insets(10, 10, 10, 10);     //what's this??
        
   namePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(0), "Stadium Registration"));
   
   constraints.gridx = 0;
   constraints.gridy = 0;            
   namePanel.add(new JLabel("Stadium Name "),constraints);
   
   constraints.gridx = 1;
   name= new JTextField(20);
   namePanel.add(name,constraints);
   
   constraints.gridx = 0;
   constraints.gridy = 1; 
   namePanel.add(new JLabel("Capacity"),constraints);
   constraints.gridx = 1;
   capacity = new JTextField(20);
   namePanel.add(capacity,constraints);
   
   
   constraints.gridx=0;
   constraints.gridy=2;
   
   namePanel.add(new JLabel("Date "),constraints);
   
   constraints.gridx=1;
   date = new DateField();    //not of Jframe
   namePanel.add(date,constraints);   //here date field
   
   constraints.gridx=0;
   constraints.gridy=3;
   namePanel.add(new JLabel("Description "),constraints);
   constraints.gridx=1;
   description = new JTextArea(5,20);
   JScrollPane descript = new JScrollPane(description);
   descript.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   namePanel.add(descript,constraints);
   
   constraints.gridx=0;
   constraints.gridy=4;
   namePanel.add(new JLabel("Street Address"),constraints);
   
   constraints.gridx=1;
   JTextField street = new JTextField(20);
   namePanel.add(street,constraints);
   
   
   constraints.gridx=0;
   constraints.gridy=5;
   namePanel.add(new JLabel("City"),constraints);
   constraints.gridx=1;
   JTextField city = new JTextField(20);
   namePanel.add(city,constraints);
   
   constraints.gridx=0;
   constraints.gridy=6;
   namePanel.add(new JLabel("Country "),constraints);
    
   constraints.gridx=1;
   JComboBox country = new JComboBox(getCountries());
   namePanel.add(country,constraints);
    
   constraints.gridx=0;
   constraints.gridy=7;
   namePanel.add(new JLabel("Post Code"),constraints);
   constraints.gridx=1;
   JTextField postCode =new JTextField(20);
   namePanel.add(postCode,constraints);
   
   
   /*
    * 
    constraints.gridx=0;
   constraints.gridy=8;                     //Missing Feature
   namePanel.add(new JLabel("Image "),constraints);
    
   constraints.gridx=1;
   namePanel.add(new JButton("Open"),constraints);//new JFileChooser()
   */
  
   constraints.gridx=1;
   constraints.gridy=8;
   JPanel operPanel = new JPanel();
   operPanel.setLayout(new FlowLayout());
    
    saveBtn = new JButton("Save");
    saveBtn.addActionListener(this);    
    ImageIcon saveIcon= new ImageIcon("save.png");
    
    saveBtn.setIcon(saveIcon);
    operPanel.add(saveBtn);
    
    cancelBtn = new JButton("Cancel");
    cancelBtn.addActionListener(this);
    ImageIcon cancelIcon = new ImageIcon("cancel.png");
    cancelBtn.setIcon(cancelIcon);
    operPanel.add(cancelBtn);
    
   // namePanel.setBackground(new Color(255,255,255,90));
    
    namePanel.add(operPanel,constraints);
   //namePanel.setOpaque(false);
   
   add(namePanel);
   setVisible(true);
    /*
    JPanel operPanel = new JPanel();
    operPanel.setLayout(new FlowLayout());
    operPanel.add(new JButton("Save"));
    operPanel.add(new JButton("X"));
    add(operPanel);
    */
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
    
public void paintComponent(Graphics g){//for image
    Graphics2D g2d = (Graphics2D) g;
    try{
            img = ImageIO.read(new File("StadiumBackground.jpg"));
        }
        catch(IOException e){
            System.out.println(e.toString());
      }
      g2d.drawImage(img,0,0,600,600,null);
    }   
    
 public void actionPerformed(ActionEvent e){
      String cmd = e.getActionCommand();
  
      if(cmd.equals("Save")){
          System.out.println(name.getText()+" "+date.getText()+" "+capacity.getText());
      }
      else{
          System.exit(0);
    }
   }
}