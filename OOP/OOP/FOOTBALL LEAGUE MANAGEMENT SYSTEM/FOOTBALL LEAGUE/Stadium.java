import java.util.*;
import java.io.*;

public class Stadium implements Serializable{
    private String name,description;
    private Address add;
    private int capacity;
    private Date dateOfInaug;
    //Picture pic;
    private String imgLoc;
    
    public Stadium(String name,int capacity,Date dateOfInaug,String streetAddress,String city,String country,String postCode,String description){
        this.name = name;
        this.description = description;
        add=new Address(streetAddress,city,country,postCode);
        this.capacity = capacity;
        this.dateOfInaug = dateOfInaug;     //new Date(year,mont,date) def
        
    }
    
    public String toString(){
        return name+", "+dateOfInaug;
     }
     
    public void setImageLocation(String location){
        imgLoc=location;
    }
    public void saveObject() throws IOException{
        File file = new File("stadium_file.txt");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream objOut = new ObjectOutputStream(fos);
        objOut.writeObject(new Stadium("Stamford Bridge",69000,new Date(31,10,1999),"House#53","Isld","Pakistan","44000","hello world!"));
        
    }
    public static Stadium getObject(){
        ObjectInputStream objIn;
        try{
        objIn = new ObjectInputStream(new FileInputStream(new File("stadium_file.txt")));
        return (Stadium)objIn.readObject();
        }
        catch(Exception ex){
            System.out.println("LOL");
            return new Stadium("Stamford Bridge",69000,new Date(31,10,1999),"House#53","Isld","Pakistan","44000","hello world!");
        }
        
    }
    public static void main(){
        Stadium std = new Stadium("Stamford Bridge",69000,new Date(31,10,1999),"House#53","Isld","Pakistan","44000","hello world!");
        try{
            std.saveObject();
        }
        catch(IOException ex){
            System.out.println("FILE NOT FOUND!");
        }
        
        Stadium stdObj = getObject();
        System.out.println(stdObj.toString());
    }
    public String getImageLocation(){
        return imgLoc;
    }
    
    
}